package com.example.codetest.simulation.c14503;
// https://velog.io/@hammii/백준-14503-로봇-청소기-java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14503_1 {
    public static int N, M;
    public static int[][] map;
    public static int cnt = 0;
    public static int[] dy = {-1, 0, 1, 0}; // 북,동,남,서
    public static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        clean(r, c, d);
        System.out.println(cnt);
    }

    public static void clean(int row, int col, int dir) {
        if (map[row][col] == 0) {
            map[row][col] = 2;
            cnt++;
        }

        boolean flag = false;
        int nDir, ny, nx;
        int origin = dir;
        for (int i = 0; i < 4; i++) {
            nDir = (dir + 3) % 4;
            ny = row + dy[nDir];
            nx = col + dx[nDir];

            if (ny > 0 && nx > 0 && ny < N && nx < M) {
                if (map[ny][nx] == 0) {
                    clean(ny, nx, nDir);
                    flag = true;
                    break;
                }
            }
            dir = nDir;
        }

        if (!flag) {
            nDir = (origin + 2) % 4;
            ny = row + dy[nDir];
            nx = col + dx[nDir];

            if (ny > 0 && nx > 0 && ny < N && nx < M) {
                if (map[ny][nx] != 1) {
                    clean(ny, nx, origin);
                }
            }
        }
    }
}

