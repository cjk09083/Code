package com.example.codetest.dynamic_pg.c10844;
// https://developer-mac.tistory.com/70

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main_10844_1 {

    static Long[][] dp;
    static int N;
    final static long MOD = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new Long[N + 1][10];

        // 첫번째 자릿수는 1로 초기화
        for(int i = 0; i < 10; i++) dp[1][i] = (long) 1;
        long result = 0;

        // 마지막 자릿수인 1~9까지의 경우의 수를 모두 더해준다.
        for(int i = 1; i <= 9; i++) {
            result += sol(N, i);
        }
        System.out.println(result % MOD);
        br.close();
    }

    static long sol(int digit, int val) {
        if(digit == 1) return dp[digit][val];

        if(dp[digit][val] == null) {
            if(val == 0) {
                dp[digit][val] = sol(digit - 1 ,1);
            }
            else if(val== 9) {
                dp[digit][val] = sol(digit - 1, 8);
            }
            else {
                dp[digit][val] = sol(digit - 1, val - 1)
                        + sol(digit - 1, val + 1);
            }
        }
        return dp[digit][val] % MOD;
    }

}
