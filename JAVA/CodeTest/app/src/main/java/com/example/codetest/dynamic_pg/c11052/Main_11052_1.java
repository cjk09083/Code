package com.example.codetest.dynamic_pg.c11052;
// https://developer-mac.tistory.com/69

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11052_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];

        String[] str = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) arr[i] = Integer.parseInt(str[i-1]);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + arr[j]);
            }
        }

        System.out.println(dp[n]);
        br.close();
    }

}
