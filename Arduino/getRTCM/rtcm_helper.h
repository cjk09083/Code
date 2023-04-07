// header guard to prevent multiple inclusions of the same header
#ifndef RTCM_HELPER_H
#define RTCM_HELPER_H

#include <Arduino.h>
#include <SoftwareSerial.h>

// RTCM message types to forward over the lora
const int type_list[] = { 1074, 1077, 1804, 1087, 1094, 1097, 1124, 1127, 1230, 4072, 1005 };

// Function prototypes for handling RTCM data
void handle_data(byte* raw, int size, Stream* lora, const int* type_list, int type_list_size, int aux_pin, const bool debug[]);
bool contains(const int* arr, int arrSize, int num);
void wait_aux(int cnt, int msg_type, int scale, int aux_pin, const bool debug[]);
int find_header(byte* data, int rtcm_index, int size);
int get_rtcm_type(byte* rtcm_message);
int get_rtcm_length(byte* rtcm_message);

#endif
