package com.example.codetest.brute_recursive.c1248;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1248_1 {
    // https://herong.tistory.com/entry/BOJ-1248-%EB%A7%9E%EC%B6%B0%EB%B4%90-Java
    // https://m.blog.naver.com/PostView.nhn?blogId=codersit&logNo=221438720134&categoryNo=0&proxyReferer=https:%2F%2Fwww.google.com%2F

    static int N;
    static int[] numArr;
    static char[] inputLine;
    static char[][] signMap;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        inputLine = br.readLine().toCharArray();

        signMap = new char[N][N];
        int idx = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                signMap[i][j] = inputLine[idx++];
            }
        }

        numArr = new int[N];
        sol(0);
    }

    private static void sol(int depth) {
        if (depth == N) {
            for (int i : numArr) {
                System.out.print(i + " ");
            }
            System.out.println();
            System.exit(0); // 프로그램 종료
        }
        for (int i = -10; i <= 10; i++) {
            numArr[depth] = i;
            if (check(depth)) {
                sol(depth + 1);
            }
        }
    }

    private static boolean check(int idx) {
        for (int i = 0; i <= idx; i++) {
            int sum = 0;
            for (int j = i; j <= idx; j++) {
                sum += numArr[j];
                if (signMap[i][j] != (sum == 0 ? '0' : (sum > 0 ? '+' : '-'))) {
                    return false;
                }
            }
        }
        return true;
    }
}
