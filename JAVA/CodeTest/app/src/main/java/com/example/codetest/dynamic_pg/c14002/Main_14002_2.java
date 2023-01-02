package com.example.codetest.dynamic_pg.c14002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_14002_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N];
        int[] arr = new int[N];
        int[] cache = new int[N];

        String[] str = br.readLine().split(" ");

        int max = -1;
        int idx = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str[i]);
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    cache[i] = j;
                }
            }

            if(dp[i] > max){
                max = dp[i];
                idx = i;
            }
        }

        int [] answer = new int[max];
        int index = idx;

        for(int x = max-1; x >= 0; x--){
            answer[x] = arr[index];
            index = cache[index];
        }

        System.out.println(max);
        for(int x=0; x<max; x++) System.out.print(answer[x]+" ");

        br.close();
    }

}
