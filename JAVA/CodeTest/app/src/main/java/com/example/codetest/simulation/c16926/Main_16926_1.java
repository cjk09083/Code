package com.example.codetest.simulation.c16926;
// https://hunucho.tistory.com/entry/Baekjoon-16927-배열-돌리기-2-JAVA [훈발자:티스토리]

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_16926_1 {
    static int n, m, r;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        // 그룹(Math.min(n, m) / 2)개를 각각 회전
        for (int i = 0; i < Math.min(n, m) / 2; i++) rotate(i, r);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                sb.append(arr[i][j]).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void rotate(int loc, int count) {
        int V_mod = 2 * (n - 2 * loc) + 2 * (m - 2 * loc - 2);
        count %= V_mod;
        for (int k = 0; k < count; k++) {
            int save = arr[loc][loc];
            for (int j = loc; j < m - loc - 1; j++) // upside
                arr[loc][j] = arr[loc][j + 1];
            for (int i = loc; i < n - loc - 1; i++) // rightside
                arr[i][m - loc - 1] = arr[i + 1][m - loc - 1];
            for (int j = m - loc - 2; j >= loc; j--) // downside
                arr[n - loc - 1][j + 1] = arr[n - loc - 1][j];
            for (int i = n - loc - 2; i >= loc; i--) // leftside
                arr[i + 1][loc] = arr[i][loc];
            arr[loc + 1][loc] = save;
        }
    }

}

