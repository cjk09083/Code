package com.example.codetest.dynamic_pg2.c1932;

/* https://girawhale.tistory.com/52
아래에서 위로 각 층마다 최대값 저장
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1932_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][];

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            dp[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Integer.parseInt(str[j]);
            }
        }

        for (int i = N - 1; i > 0; i--) {
            for (int j = 0; j < i; j++)
                dp[i-1][j] += Math.max(dp[i][j], dp[i][j + 1]);
        }

        System.out.println(dp[0][0]);

        br.close();
    }
}

