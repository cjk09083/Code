#include "rtcm_helper.h"

// Finds the header position in the data buffer
int find_header(byte* data, int rtcm_index, int size) {
  for (int i = rtcm_index; i < size; i++) {
    if (data[i] == 0xD3) {
      return i;
    }
  }
  return -1;
}

// Handles the data received and sends the relevant RTCM messages over the LoRa stream
void handle_data(byte* data, int size, Stream* lora, const int* type_list, int type_list_size, int aux_pin, const bool debug[]) {
  int rtcm_index = 0;
  int msg_cnt = 0;

  // Loop through the data within its size
  while (rtcm_index < size) {
    
    // Find the position of the RTCM header in the data
    rtcm_index = find_header(data, rtcm_index, size);
    if (rtcm_index < 0 || rtcm_index >= size) break;

    // Get a pointer to the current RTCM message
    byte* rtcm = &data[rtcm_index];

    // Obtain the length and type of the current RTCM message
    int msg_len = get_rtcm_length(rtcm);
    int msg_type = get_rtcm_type(rtcm);

    // If the message type is in the type_list, process and send the message
    if (contains(type_list, type_list_size, msg_type)) {
      // Limit the message length to the remaining data size
      msg_len = min(msg_len, size - rtcm_index);
      msg_cnt ++;

      if (debug[0]){
        // Print message information to the serial monitor
        Serial.print(msg_cnt);
        Serial.print(" type: ");
        Serial.print(msg_type);
        Serial.print(" MSG Length: ");
        Serial.print(msg_len);
        Serial.print(" idx: ");
        Serial.print(rtcm_index);
        Serial.print(" / ");
        Serial.println(size);
      }

      // If the message is within the data size, send it over the LoRa stream
      if ((rtcm_index + msg_len) <= size) {
        byte* msg = &data[rtcm_index];

        if (debug[1]){
          // Print out message content
          for( int i = 0; i < msg_len; i++){
            char hexString[3]; 
            sprintf(hexString, "%02X", msg[i]); // Convert to hexadecimal format and keep it in 2 digits
            Serial.print(hexString);
            Serial.print(" ");
          }
          Serial.println();
        }        

        wait_aux(msg_cnt, msg_type, 10, aux_pin, debug);
        digitalWrite(LED_BUILTIN, LOW);
        lora->write(msg, msg_len);
        digitalWrite(LED_BUILTIN, HIGH);
        delay(100);
      }
    } else {
      // If the message type is not in the type_list, skip to the next byte
      msg_len = 1;
    }

    // Increment the index to process the next message
    rtcm_index += max(msg_len, 1);
  }
}

// Checks if a given number is present in an array
bool contains(const int* arr, int arrSize, int num) {
  for (int i = 0; i < arrSize; ++i) {
    if (arr[i] == num) {
      return true;
    }
  }
  return false;
}

// Waits for the aux pin to be ready before transmitting data
void wait_aux(int cnt, int msg_type, int scale, int aux_pin, const bool debug[]) {
  for (int i = 0; i < scale * 10; i++) {
    int val = digitalRead(aux_pin);
    if (debug[2]){
      Serial.print(cnt);
      Serial.print(" type: ");
      Serial.print(msg_type);
      Serial.print(" ");
      Serial.print(i / (float)scale);
      Serial.print(" s aux: ");
      Serial.println(val);
    }
    if (val > 0) return;
    delay(1000 / scale);
  }
}

// Retrieves the RTCM message type from the given message
int get_rtcm_type(byte* rtcm_message) {
  int message_type = ((rtcm_message[3] << 4) | (rtcm_message[4] >> 4)) & 0x0FFF;
  return message_type;
}

// Retrieves the RTCM message length from the given message
int get_rtcm_length(byte* rtcm_message) {
  int message_length = ((rtcm_message[1] << 8) | (rtcm_message[2])) & 0x3FFF;
  return message_length + 6;
}
