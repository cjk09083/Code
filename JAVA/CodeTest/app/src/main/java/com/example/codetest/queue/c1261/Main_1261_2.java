package com.example.codetest.queue.c1261;

// https://steady-coding.tistory.com/59

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1261_2 {

    static class Point {
        int x, y, breakCnt;
        public Point(int x, int y, int breakCnt) {
            this.x = x;
            this.y = y;
            this.breakCnt = breakCnt;
        }
    }

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] info = br.readLine().split("");
            for (int j = 0; j < M; j++) map[i][j] = Integer.parseInt(info[j]);
        }
        bfs(map);
    }

    static void bfs(int[][] map) {
        int[][] visited = new int[N][M];
        int[] dx = { 0, 0, 1,-1 };
        int[] dy = { 1,-1, 0, 0 };
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) Arrays.fill(visited[i], Integer.MAX_VALUE);                     // x, y 까지 왔을 때 벽을 부순 최소 개수를 표시하기 위해 전제 배열의 값 최대로 초기화
        visited[0][0] = 0;
        queue.add(new Point(0, 0, 0));

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                int breakCnt = now.breakCnt;

                if (0 <= nx && nx < N && 0 <= ny && ny < M) {                                       // 방의 범의 범위를 벗어나면 안됨
                    if (nx == N - 1 && ny == M - 1) {                                                   // 목적지에 도착했을 때
                        visited[nx][ny] = Math.min(breakCnt, visited[nx][ny]);                          // 목적지까지 왔을 때 부순벽의 개수를 저장되어있는 값이랑 비교해서 더 작은 값 저장
                        continue;
                    }
                    if (map[nx][ny] == 1) breakCnt += 1;                                                // 다음에 가야할 칸이 벽이면 부숨
                    if (visited[nx][ny] <= breakCnt) continue;                                          // 누군가가 이미 그 칸으로 이동했을 때 저장한 부순 벽의 개수 <= 다음 칸으로 이동하기 위해 벽을 부순 개수
                    queue.add(new Point(nx, ny, breakCnt));
                    visited[nx][ny] = breakCnt;
                }
            }
        }
        System.out.println(visited[N - 1][M - 1]);
    }

}

