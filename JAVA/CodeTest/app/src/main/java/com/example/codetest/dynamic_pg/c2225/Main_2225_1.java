package com.example.codetest.dynamic_pg.c2225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://hu-coding.tistory.com/28
// K=1, N=0인 경우를 제외하면, DP[K][N]에 대하여 아래의 식을 나타낼 수 있다.
// DP[K][N] = DP[K-1][0] + DP[K-1][1] + … + DP[K-1][N]
// DP[K][N] = DP[K][N-1] + DP[K-1][N]

public class Main_2225_1 {
    static int mod = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);
        int[][] dp = new int[K+1][N+1];

        for(int i=1; i<=K; i++) {
            dp[i][0] = 1;
            for(int j=1; j<=N; j++) {
                dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % mod;
            }
        }
        System.out.println(dp[K][N]);
        br.close();
    }

}
