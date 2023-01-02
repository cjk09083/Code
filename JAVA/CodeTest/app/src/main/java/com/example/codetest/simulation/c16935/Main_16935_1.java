package com.example.codetest.simulation.c16935;
// https://hunucho.tistory.com/entry/Baekjoon-16927-배열-돌리기-2-JAVA [훈발자:티스토리]

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_16935_1 {
    static int N, M, R;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) arr = rotate(Integer.parseInt(st.nextToken()),arr);

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) sb.append(arr[i][j]).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static int[][] rotate(int cmd, int[][] origin) {
        int[][] result = new int[N][M];
        int temp = N;
        switch (cmd){
            case 1:
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) result[i][j] =  origin[(N-1)-i][j];
                }
                break;
            case 2:
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) result[i][j] = origin[i][(M-1)-j];
                }
                break;
            case 3:
                N = M;
                M = temp;
                result = new int[N][M];
                arr = new int[N][M];
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) result[i][j] = origin[(M-1)-j][i];
                }
                break;
            case 4:
                N = M;
                M = temp;
                result = new int[N][M];
                arr = new int[N][M];
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) result[i][j] = origin[j][(N-1)-i];
                }
                break;
            case 5:
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (i < N / 2 && j < M / 2) result[i][j+ M / 2] = origin[i][j];
                        else if (i < N / 2 && j >= M / 2)  result[i + N / 2][j] = origin[i][j];
                        else if (i >= N / 2 && j >= M / 2)  result[i][j - M / 2] = origin[i][j];
                        else  result[i - N / 2][j] = origin[i][j];
                    }
                }
                break;
            case 6:
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {

                        if (i < N / 2 && j < M / 2) result[i + N / 2][j] = origin[i][j];
                        else if (i < N / 2 && j >= M / 2)  result[i][j - M / 2] = origin[i][j];
                        else if (i >= N / 2 && j >= M / 2)  result[i - N / 2][j] = origin[i][j];
                        else  result[i][j + M / 2] = origin[i][j];
                    }
                }
                break;
        }

        return result;
    }

}

