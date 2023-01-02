package com.example.codetest.math.c1978;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1978_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int c = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");

        int result = 0;

        for(int i=0; i < c; i++){
            int n = Integer.parseInt(str[i]);
            int isPrime = 0;

            for (int j = 2; j <= n; j++){
                if (n % j == 0) {
                    isPrime++;
                }
            }
            if(isPrime == 1) {
                result++;
            }
        }

        System.out.println(result);

        br.close();
    }
}


