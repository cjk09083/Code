package com.example.codetest.brute.c2309;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2309_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numArr = {0,0,0,0,0,0,0,0,0};
        for (int i = 0; i < 9; i++) numArr[i] = Integer.parseInt(br.readLine());
        int sum = Arrays.stream(numArr).sum() - 100;

        boolean comp = false;
        for (int i = 0; i < 9; i++){
            if(comp) break;
            for (int j = i+1; j < 9; j++){
                if(numArr[i]+numArr[j] == sum) {
                    numArr[i] = 1000;
                    numArr[j] = 1000;
                    comp = true;
                    break;
                }
            }
        }

        numArr = Arrays.stream(numArr).sorted().toArray();
        for (int i = 0; i < 7; i++) System.out.println(numArr[i]);
        br.close();
    }


}

