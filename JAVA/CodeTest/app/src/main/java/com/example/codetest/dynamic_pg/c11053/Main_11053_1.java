package com.example.codetest.dynamic_pg.c11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_11053_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N];
        int[] arr = new int[N];

        String[] str = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                System.out.println("i: "+i+", j: "+j
                        +", arr: "+arr[j] +" < "+ arr[i]+" = " + (arr[j] < arr[i])
                        +", dp: "+dp[j] +" < "+ (dp[j]+1)+" = "+(dp[i] < dp[j] + 1));
                if(arr[j] < arr[i] && dp[i] < dp[j] + 1) {
                    System.out.println("dp[i]: "+ dp[i] + " = dp[j]: "+dp[j] + " + 1 = "+(dp[j]+1));
                    dp[i] = dp[j] + 1;
                }
            }
        }

        System.out.println(Arrays.toString(dp));
        int max = Arrays.stream(dp).max().getAsInt();
        System.out.println(max);
        br.close();
    }

}
