package com.example.codetest.dynamic_pg2.c13398;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_13398_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp1 = new int[N];
        int[] dp2 = new int[N];
        int[] arr = new int[N];
        int max = Integer.MIN_VALUE;

        String[] str = br.readLine().split(" ");
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(str[i]);

        dp1[0] = arr[0];
        for (int i = 1; i < N; i++) {
            dp1[i] = Math.max(dp1[i - 1] + arr[i], arr[i]);
        }

        dp2[N-1] = arr[N-1];
        for(int i=N-2;i>=0;i--) {
            dp2[i] = Math.max(dp2[i+1]+arr[i],arr[i]);
        }

        for(int i=0;i<N;i++) {
            max = Math.max(max,dp1[i]);
            if(i > 0 && i < N-1) max = Math.max(max,dp1[i-1]+dp2[i+1]);     // i자리 제외
        }
        System.out.println(max);
        br.close();
    }
}

