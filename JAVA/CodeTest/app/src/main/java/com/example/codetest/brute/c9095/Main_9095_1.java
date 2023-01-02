package com.example.codetest.brute.c9095;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9095_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = 10;
        int[] numArr = new int[max+1];

        numArr[1] = 1;  // 1 = 1
        numArr[2] = 2;  // 2 = 1 + 1 = 2
        numArr[3] = 4;  // 3 = 1 + 1 + 1 = 1 + 2 = 2 + 1 = 3

        for (int i = 4; i <= max; i++) numArr[i] = numArr[i-1] + numArr[i-2] + numArr[i-3];

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(numArr[num]).append('\n');
        }

        System.out.println(sb);
        br.close();
    }
}

