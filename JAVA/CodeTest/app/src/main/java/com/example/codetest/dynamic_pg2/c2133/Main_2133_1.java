package com.example.codetest.dynamic_pg2.c2133;
// https://squareyun.tistory.com/32
// https://yabmoons.tistory.com/536
// F[N] = ( F[N - 2] * F[2] ) + ( F[N - 4] * 2 ) + ( F[N - 6] * 2) + ( F[N - 8] * 2 ) + ... + ( F[0] * 2 )

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2133_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        int result;
        if (N % 2 == 1) {
            result = 0;
        } else {
            dp[0] = 1;
            dp[2] = 3;

            for (int i = 4; i <= N; i += 2) {
                dp[i] = dp[i - 2] * 3;
                for (int j = i - 4; j >= 0; j -= 2) {
                    dp[i] += dp[j] * 2;
                }
            }
            result = dp[N];
        }
        System.out.println(result);
    }
}

