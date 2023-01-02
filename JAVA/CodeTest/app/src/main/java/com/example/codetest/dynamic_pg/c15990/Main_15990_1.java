package com.example.codetest.dynamic_pg.c15990;
// https://velog.io/@jkh9615/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-15990-1-2-3-%EB%8D%94%ED%95%98%EA%B8%B0-5-Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_15990_1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[100000 + 1][4];
        long ref = 1000000009;

        dp[1][1] = 1; // 1
        dp[2][2] = 1; // 2
        dp[3][1] = 1; // 2+1
        dp[3][2] = 1; // 1+2
        dp[3][3] = 1; // 3

        for(int i = 4; i <= 100000; i++) {
            dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % ref;
            dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % ref;
            dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % ref;
        }

        for(int i = 0; i < n; i++) {
            int t = Integer.parseInt(br.readLine());
            sb.append((dp[t][1] + dp[t][2] + dp[t][3]) % ref).append("\n");
        }

        System.out.println(sb);
    }

}
