package com.example.codetest.brute_permutation.c10974;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10974_1 {

    static StringBuilder sb = new StringBuilder();
    static int n;
    private static int[] numArr, result;
    private static boolean[] visit;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        numArr = new int[n];
        result = new int[n];
        visit = new boolean[n+1];

        for (int i=0; i<n ; i++) numArr[i] = i+1;

        dfs(0);

        System.out.print(sb);
        br.close();
    }


    private static void dfs(int index) {
        if(index == n) {
            for (int i : result) sb.append(i).append(" ");
            sb.append('\n');
        }else {
            for (int i=0; i<n; i++) {
                if(!visit[i]) {
                    visit[i] = true;
                    result[index] = numArr[i];
                    dfs(index + 1);
                    visit[i] = false;
                }
            }
        }
    }

}
