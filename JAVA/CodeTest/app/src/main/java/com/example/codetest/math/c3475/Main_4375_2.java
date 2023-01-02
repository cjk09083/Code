package com.example.codetest.math.c3475;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_4375_2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        int n, value;
        String str;
        while (true) {
            str = br.readLine();
            if(str == null || str.isEmpty()) break;
            n = Integer.parseInt(str);
            value = 0;
            for (int i = 1; i < 2147483647; i++) {
                value = ((value * 10) + 1) % n;
                if (value == 0) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}

