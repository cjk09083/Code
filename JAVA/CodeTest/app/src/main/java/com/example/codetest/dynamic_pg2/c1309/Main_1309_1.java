package com.example.codetest.dynamic_pg2.c1309;

/* https://steady-coding.tistory.com/156
dp[N][0] = dp[N - 1][0] + dp[N - 1][1] + dp[N - 1][2]
dp[N][1] = dp[N - 1][0] + dp[N - 1][2]
dp[N][2] = dp[N - 1][0] + dp[N - 1][1]
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1309_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int MOD = 9901;

        long[][] dp = new long[N + 1][3];       // [i][K]에서 K=0 : 아무곳에도 x
        dp[1][0] = dp[1][1] = dp[1][2] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
        }

        long result = (dp[N][0] + dp[N][1] + dp[N][2]) % MOD;
        System.out.println(result);
        br.close();
    }
}

