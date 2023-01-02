package com.example.codetest.math.c17427;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_17427_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= i; j++) {
                if (i%j == 0) {
                    result += j;
                }
            }
        }

        System.out.println(result);
        br.close();
    }
}

