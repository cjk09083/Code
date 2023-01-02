package com.example.codetest.queue.c13549;

// https://velog.io/@leeinae/Algorithm-%EB%B0%B1%EC%A4%801697-%EC%88%A8%EB%B0%94%EA%BC%AD%EC%A7%88

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_13549_1 {
    static int N,K;
    static int[] visited = new int[100001];

    static class Point {
        int idx;
        int time;
        public Point(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        K = Integer.parseInt(str[1]);
        bfs();
    }

    public static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(N,1));
        visited[N] = 1;

        while (!q.isEmpty()) {
            Point now = q.poll();
            if(now.idx+1>=0 && now.idx+1<=100000){ // 앞으로 한칸
                if(visited[now.idx+1] == 0 || visited[now.idx+1] > now.time+1){
                    visited[now.idx+1] = now.time+1;
                    q.add(new Point(now.idx + 1, now.time + 1));
                }
            }

            if(now.idx-1>=0 && now.idx-1<=100000){ // 뒤로 한칸
                if(visited[now.idx-1] == 0 || visited[now.idx-1] > now.time+1) {
                    visited[now.idx - 1] = now.time + 1;
                    q.add(new Point(now.idx - 1, now.time + 1));
                }
            }

            if(now.idx*2>=0 && now.idx*2<=100000){ // 순간이동
                if(visited[now.idx*2] == 0 || visited[now.idx*2] > now.time) {
                    visited[now.idx*2] = now.time;
                    q.add(new Point(now.idx*2, now.time));
                }
            }

        }
        System.out.println(visited[K]-1);
    }

}

