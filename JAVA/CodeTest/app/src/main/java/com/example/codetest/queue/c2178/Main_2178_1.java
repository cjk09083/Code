package com.example.codetest.queue.c2178;
// https://jellyinghead.tistory.com/14

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2178_1 {
    static int N,M,L = Integer.MAX_VALUE;
    static int[][] list;
    static boolean[][] visit;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        visit = new boolean[N][M];
        list = new int[N][M];

        for(int i = 0; i < N; i++) {
            str = br.readLine().split("");
            for(int j = 0; j < M; j++) list[i][j] = Integer.parseInt(str[j]);
        }

        bfs();
        System.out.println(L);
    }

    public static void bfs() {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0,0,1});
        visit[0][0] = true;

        while(!que.isEmpty()) {
            int curX = que.peek()[0];
            int curY = que.peek()[1];
            int len = que.peek()[2];
            que.poll();
            if(curX==N-1 && curY == M-1) L = Math.min(L,len);

            for(int i=0; i<4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < M){
                    if(list[nx][ny] == 1 && !visit[nx][ny]){
                        que.add(new int[]{nx,ny,len+1});
                        visit[nx][ny] = true;
                    }
                }
            }
        }
    }

}

