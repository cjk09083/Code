package com.example.codetest.brute_permutation.c10971;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10971_1 {
    static int n, result = Integer.MAX_VALUE;
    private static int[][] numArr;
    private static boolean[] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);

        numArr = new int[n][n];
        visit = new boolean[n];

        for (int i = 0; i < n; i++){
            String[] strArr = br.readLine().split(" ");
            for (int j = 0; j < n; j++) numArr[i][j] = Integer.parseInt(strArr[j]);
        }

        visit[0] = true;
        sol(0,0,0, 0);

        System.out.println(result);

    }

    private static void sol(int depth, int start, int now, int cost){
        if(depth == n){
            result = Math.min(result, cost);
            return;
        }

        for (int j = 0; j < n ; j++) {
            if (numArr[now][j] > 0) {
                if (j == start && depth == n-1) {
                    cost += numArr[now][j];
                    sol(depth + 1,start,j,cost);
                } else if (!visit[j]) {
                    visit[j] = true;
                    cost += numArr[now][j];
                    sol(depth + 1,start,j,cost);
                    cost -= numArr[now][j];
                    visit[j] = false;
                }
            }
        }
    }
}
