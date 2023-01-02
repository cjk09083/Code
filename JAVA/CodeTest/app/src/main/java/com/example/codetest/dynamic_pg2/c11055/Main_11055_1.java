package com.example.codetest.dynamic_pg2.c11055;

/* https://m.blog.naver.com/occidere/220793914361
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_11055_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int max = 0;
        int[] arr = new int[N+1], dp = new int[N+1];

        String[] str = br.readLine().split(" ");
        for (int j = 1; j <= N; j++) arr[j] = Integer.parseInt(str[j-1]);

        for(int i = 1; i <= N; i++){
            dp[i] = arr[i];
            for(int j = 1; j < i; j++){
                if(arr[j]<arr[i] && dp[i] < dp[j]+arr[i]) dp[i] = dp[j] + arr[i];
            }
            max = Math.max(max,dp[i]);
        }

        System.out.println(max);
        br.close();
    }
}

