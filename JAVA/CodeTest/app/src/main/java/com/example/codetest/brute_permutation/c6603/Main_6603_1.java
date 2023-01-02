package com.example.codetest.brute_permutation.c6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6603_1 {

    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;

            int[] arr = new int[n];
            boolean[] visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            sol(arr, visited, 0, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void sol(int[] arr, boolean[] visited, int idx, int depth) {
        if (depth == 6) {
            for (int i = 0; i < arr.length; i++) {
                if (visited[i]) sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            sol(arr, visited, i, depth + 1);
            visited[i] = false;
        }
    }
}