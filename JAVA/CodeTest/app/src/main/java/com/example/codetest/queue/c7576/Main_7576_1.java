package com.example.codetest.queue.c7576;

// https://bcp0109.tistory.com/9

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576_1 {
    static int N,M;
    static int[][] box;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    static class Point {
        int x, y, day;

        public Point(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        box = new int[M][N];

        for(int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
    }

    public static void bfs() {
        Queue<Point> q = new LinkedList<>();
        int day = 0;

        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(box[i][j] == 1)
                    q.offer(new Point(i, j, 0));
            }
        }

        while(!q.isEmpty()) {
            Point dot = q.poll();
            day = dot.day;

            for(int i=0; i<4; i++) {
                int nx = dot.x + dx[i];
                int ny = dot.y + dy[i];

                if(0 <= nx && nx < M && 0 <= ny && ny < N) {
                    if(box[nx][ny] == 0) {
                        box[nx][ny] = 1;
                        q.add(new Point(nx, ny, day+1));
                    }
                }
            }
        }

        if(checkTomato()) System.out.println(day);
        else System.out.println(-1);
    }

    static boolean checkTomato() {
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(box[i][j] == 0)
                    return false;
            }
        }
        return true;
    }

}

