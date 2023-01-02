package com.example.codetest.dynamic_pg2.c11054;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_11054_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] high = new int[N];
        int[] low = new int[N];
        int[] arr = new int[N];

        String[] str = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str[i]);
            high[i] = 1;
            low[i] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
//                System.out.println("1 i: "+i+", j: "+j
//                        +", arr: "+arr[j] +" < "+ arr[i]+" = " + (arr[j] < arr[i])
//                        +", dp: "+high[j] +" < "+ (high[j]+1)+" = "+(high[i] < high[j] + 1));
                if(arr[j] < arr[i] && high[i] < high[j] + 1) {
//                    System.out.println("1 dp[i]: "+ high[i] + " = dp[j]: "+high[j] + " + 1 = "+(high[j]+1));
                    high[i] = high[j] + 1;
                }
            }

            int k = N-1-i;
            for (int j = N-1; j > k; j--) {
                System.out.println("2 k: "+k+", j: "+j
                        +", arr: "+arr[j] +" < "+ arr[k]+" = " + (arr[j] > arr[k])
                        +", dp: "+low[j] +" > "+ (low[j]+1)+" = "+(low[k] < low[j] + 1));
                if(arr[j] < arr[k] && low[k] < low[j] + 1 ) {
                    System.out.println("2 dp[k]: "+ low[k] + " = dp[j]: "+low[j] + " + 1 = "+(low[j]+1));
                    low[k] = low[j] + 1;
                }
            }
        }

        System.out.println(Arrays.toString(high));
        System.out.println(Arrays.toString(low));

        int max = -1;
        for (int i = 0; i < N; i++) {
            max = Math.max(max,high[i]+low[i]-1);
        }
        System.out.println(max);
        br.close();
    }
}

