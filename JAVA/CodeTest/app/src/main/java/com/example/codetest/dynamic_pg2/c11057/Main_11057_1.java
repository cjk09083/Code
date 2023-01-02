package com.example.codetest.dynamic_pg2.c11057;

/* https://sundries-in-myidea.tistory.com/77

DP[N][K] => N 자리의 숫자 길이 중 맨 뒤의 숫자가 K인 경우의 수

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_11057_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int MOD = 10007;

        // dp[N][K] => N 자리의 숫자 길이 중 맨 뒤의 숫자가 K인 경우의 수
        long[][] dp = new long[N + 1][10];
        for(int i=0; i<10; i++) dp[1][i] = 1;

        for(int i=2; i<=N; i++){
            for(int j=0; j<10; j++){
                for(int k=0; k<=j; k++){
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= MOD;
                }
            }
        }
        int sum = 0;
        for(int i=0; i<10; i++){
            sum += dp[N][i];
        }

        System.out.println(sum % MOD);
        br.close();
    }
}

