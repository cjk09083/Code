#include "rtcm_helper.h"
#include <SoftwareSerial.h>

// Create SoftwareSerial instances for ublox and lora
SoftwareSerial ublox(D1, D2); // RX, TX
SoftwareSerial lora(D5, D6); // RX, TX

// Define constants for pins and baud rates
const int AUX_PIN = D7;
const int SERIAL_BAUDRATE = 38400;
const int RADIO_BAUDRATE = 38400;
const int TIMEOUT = 100;
const int BUFFER_SIZE = 2048;
const int type_list_size = sizeof(type_list) / sizeof(type_list[0]);
const bool DEBUG[] = {true,false,true};    // {type, msg, aux}

void setup() {
  // Set the pin mode for the AUX pin and built-in LED
  pinMode(AUX_PIN, INPUT);
  pinMode(LED_BUILTIN, OUTPUT);

  // Initialize serial connections for debugging, ublox, and lora
  Serial.begin(115200);
  ublox.begin(SERIAL_BAUDRATE); // RX, TX
  lora.begin(RADIO_BAUDRATE); // RX, TX

  // Set the ublox timeout
  ublox.setTimeout(TIMEOUT);

  // Print a message to the serial monitor to indicate the start of the program
  Serial.println();
  Serial.println("Now Get RTCM");
  digitalWrite(LED_BUILTIN, HIGH);

  // Listen to the ublox SoftwareSerial instance for incoming data (sending is not affected)
  ublox.listen(); 
}

void loop() {
  // Check if data is available from the ublox SoftwareSerial instance
  if (ublox.available() > 0) {
    // Read the incoming data into a buffer
    byte data[BUFFER_SIZE];
    int size = ublox.readBytes(data, BUFFER_SIZE);

    // Print the length of the received RTCM data
    Serial.print("New RTCM DATA Len: ");
    Serial.println(size);

    // Process and handle the received data
    handle_data(data, size, &lora, type_list, type_list_size, AUX_PIN, DEBUG);

    // Flush the ublox SoftwareSerial instance to clear any remaining data
    ublox.flush();
  }
}
