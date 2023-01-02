package com.example.codetest.dynamic_pg.c14002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_14002_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N];
        int[] arr = new int[N];
        int[] cache = new int[N];
        int[] list = new int[N];

        int[][] member = new int[N][N];

        String[] str = br.readLine().split(" ");

        int max = -1;
        int idx = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str[i]);
            dp[i] = 1;
            member[i][i] = arr[i];
            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    member[i][j] = arr[j];
                    cache[i] = j;
                }
            }

            if(dp[i]>max){
                max=dp[i];
                idx=i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (member[idx][i] > 0) sb.append(member[idx][i]).append(" ");
        }
        System.out.println(max);
        System.out.println(sb);

        br.close();
    }

}
