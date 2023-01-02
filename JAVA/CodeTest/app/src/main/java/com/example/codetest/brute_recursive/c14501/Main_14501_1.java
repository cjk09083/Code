package com.example.codetest.brute_recursive.c14501;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14501_1 {
    //https://hidelookit.tistory.com/118


    //점화식
    //현재 날짜에서 소요 시간과 비용을 더해 dp에 저장한다.
    //이후, 중복될 때 최대값을 넣는다.
    //dp[i + t[i]] = max(dp[i + t[i]], dp[i] + p[i]);

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] t = new int[n];
        int[] p = new int[n];

        StringTokenizer st;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(reader.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n+1];                                                                    //dp : N일에 얻을 수 있는 최대 수익

        for (int i=0; i<n; i++) {
            if (i + t[i] <= n) dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);                 //날짜가 범위를 넘어가지 않는 경우
                                                                                                    //현재 경우의 수가 0일 수 있기 때문에 이전의 최대값을 넣어줌.
            dp[i+1] = Math.max(dp[i+1], dp[i]);                                                     //해당 날짜에 일할 수 없다면, 이전까지 일한 최대 수당을 넣어주어야 한다.
        }
        System.out.println(dp[n]);
    }
}

