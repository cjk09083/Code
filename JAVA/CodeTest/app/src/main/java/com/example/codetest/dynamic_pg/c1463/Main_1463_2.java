package com.example.codetest.dynamic_pg.c1463;
// https://odysseyj.tistory.com/19

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1463_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int[] dp = new int[number+1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= number; i++){
            // 셋 중 가장 작은 값을 사용
            dp[i] = dp[i-1] + 1;
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
        }
        System.out.println(dp[number]);
        br.close();
    }
}
