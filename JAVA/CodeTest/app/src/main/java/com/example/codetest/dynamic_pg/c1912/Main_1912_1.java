package com.example.codetest.dynamic_pg.c1912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1912_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N];
        int[] arr = new int[N];

        String[] str = br.readLine().split(" ");
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(str[i]);

        dp[0] = arr[0];
        int max = arr[0];

        for (int i = 1; i < N; i++) {
            // (이전 dp + 현재 arr값) 과 현재 arr값 중 큰 것을 dp에 저장
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
        br.close();
    }

}
