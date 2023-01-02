package com.example.codetest.queue.c2667;
// https://jellyinghead.tistory.com/14

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2667_2 {
    static int N, TN = 0;
    static int[] cnt;
    static int[][] list, team;
    static boolean[][] visit;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visit = new boolean[N][N];
        list = new int[N][N];
        team = new int[N][N];
        cnt = new int[(N+1) * (N+1)];

        for(int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for(int j = 0; j < N; j++) list[i][j] = Integer.parseInt(str[j]);
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(list[i][j] == 1 && !visit[i][j]){
                    TN++;
                    bfs(i,j);
                }
            }
        }

        System.out.println(TN);
        Arrays.sort(cnt);
        for (int j : cnt) {
            if (j > 0) System.out.println(j);
        }

    }

    public static void bfs(int row, int col) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{row,col});
        visit[row][col] = true;
        cnt[TN]++;

        while(!que.isEmpty()) {
            int curX = que.peek()[0];
            int curY = que.peek()[1];
            que.poll();

            for(int i=0; i<4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < N){
                    if(list[nx][ny] == 1 && !visit[nx][ny]){
                        que.add(new int[]{nx,ny});
                        visit[nx][ny] = true;
                        cnt[TN]++;
                    }
                }
            }
        }
    }

}

