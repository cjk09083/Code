package com.example.codetest.brute_nm.c15651;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_15651_2 {
    static StringBuilder sb = new StringBuilder();
    static char[] arr;
    static int n, m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        arr = new char[2 * m];
        for (int i = 1; i < 2 * m - 1; i+=2) arr[i] = ' ';
        arr[2 * m - 1] = '\n';
        dfs(0);

        System.out.print(sb);
        br.close();
    }

    private static void dfs(int index) {
        if(index == m)
            sb.append(arr);
        else{
            for (int i = 1; i <= n; i++) {
                arr[index * 2] = ((char) (i + '0'));
                dfs(index + 1);
            }
        }
    }
}

