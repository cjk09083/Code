package com.example.codetest.queue.c7562;
// https://jellyinghead.tistory.com/14

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7562_1 {
    static StringTokenizer st;
    static int T, L;
    static int[][] list;
    static boolean[][] visit;
    static Point start, end;
    static int[][] dir = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2},
            {1, 2}, {2, 1}, {2, -1}, {1, -2}};

    static class Point {
        int r, c, cnt;
        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            L = Integer.parseInt(br.readLine());
            list = new int[L][L];
            visit = new boolean[L][L];

            st = new StringTokenizer(br.readLine());
            start = new Point(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), 0);
            st = new StringTokenizer(br.readLine());
            end = new Point(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), 0);

            bfs(start);
        }
    }

    static void bfs(Point p) {
        Queue<Point> q = new LinkedList<>();
        q.add(p);
        visit[p.r][p.c] = true;

        while(!q.isEmpty()) {
            Point temp = q.poll();
            int tempR = temp.r;
            int tempC = temp.c;
            int cnt = temp.cnt;

            if(tempR == end.r && tempC == end.c) { // 도착
                System.out.println(temp.cnt);
                return;
            }

            for(int i = 0; i < 8; i++) { // 8방 탐색
                int nr = tempR + dir[i][0];
                int nc = tempC + dir[i][1];

                if(nr >= 0 && nr < L && nc >= 0 && nc < L && !visit[nr][nc]) {
                    q.add(new Point(nr, nc, cnt + 1));
                    visit[nr][nc] = true;
                }
            }

        }

    }

}

