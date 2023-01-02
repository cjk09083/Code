package com.example.codetest.dynamic_pg.c2193;
// https://odysseyj.tistory.com/25

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2193_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //  n자리 이친수
        long[] dp = new long[N+1];

        dp[0] = 0;              // x
        dp[1] = 1;              // 1

        // 맨 끝에 0이 오는 경우는 d[n-1]
        // 맨 끝에 1이 오는 경우는 d[n-2]
        for (int i = 2; i <= N; i++) dp[i] = dp[i-1] + dp[i-2];

        System.out.println(dp[N]);
        br.close();
    }

}
