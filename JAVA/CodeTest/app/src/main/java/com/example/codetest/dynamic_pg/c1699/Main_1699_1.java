package com.example.codetest.dynamic_pg.c1699;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// N의 제곱수의 합은 1 ~ N 까지의 수 중 제곱수인 수 + (n - 제곱수) 의 최소 제곱수 갯수 중 최소인 값 이다.
// dp[n] = (a = n-1 ~ n/2, b = n - a) 일 때, dp[a] + dp[b] 의 최솟값

public class Main_1699_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        for (int i = 1; i <= N; i++){
            dp[i] = i;
            for (int j = 1; j*j <= i; j++){
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
            System.out.println(i+":"+dp[i]);
        }
        System.out.println(dp[N]);
        br.close();
    }

}
