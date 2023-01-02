package com.example.codetest.queue.c14226;

// https://velog.io/@leeinae/Algorithm-%EB%B0%B1%EC%A4%801697-%EC%88%A8%EB%B0%94%EA%BC%AD%EC%A7%88

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_14226_1 {
    static int N;
    static boolean[][] visited = new boolean[2001][2001];

    static class Emo{
        int E;
        int C;
        int T;

        public Emo(int emoticon, int clipboard, int time) {
            this.E = emoticon;
            this.C = clipboard;
            this.T = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        bfs();
    }

    public static void bfs() {
        Queue<Emo> q = new LinkedList<>();
        q.add(new Emo(1,0,0));

        while (!q.isEmpty()) {
            Emo now = q.poll();
            int E = now.E;
            int C = now.C;
            int T = now.T;

            if(E == N){
                System.out.println(T);
                return;
            }

            if(E > 0 && E < 2000){
                if(!visited[E][E]){
                    visited[E][E] = true;
                    q.offer(new Emo(E, E, T + 1));
                }

                if (!visited[E - 1][C]) {
                    visited[E - 1][C] = true;
                    q.offer(new Emo(E - 1, C, T + 1));
                }
            }

            if (C > 0 && E + C < 2000) {
                if (!visited[E+C][C]) {
                    visited[E+C][C] = true;
                    q.offer(new Emo(E + C, C, T + 1));
                }
            }
        }
    }

}

