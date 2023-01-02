package com.example.codetest.brute.c1748;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1748_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;

        int len = 1;
        int ref = 9;
        for (int i = 1; i <= n; i++){
            result += len;
            if(i >= ref){
                ref = ref * 10 + 9;
                len += 1;
            }
        }
        System.out.println(result);
        br.close();
    }

}

