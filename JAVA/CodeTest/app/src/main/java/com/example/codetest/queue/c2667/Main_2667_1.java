package com.example.codetest.queue.c2667;
// https://jellyinghead.tistory.com/14

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2667_1 {
    static int N, TN = 0;
    static int[] cnt;
    static int[][] list, team;
    static boolean[][] visit;

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
                if(!visit[i][j]) dfs(i,j,0);
            }
        }

        System.out.println(TN);
        Arrays.sort(cnt);
        for (int j : cnt) {
            if (j > 0) System.out.println(j);
        }

    }

    public static void dfs(int row, int col, int t) {

        if(list[row][col] == 1 && !visit[row][col]){
            visit[row][col] = true;
            if(t==0) {
                TN += 1;
            }
            cnt[TN] += 1;
            team[row][col] = TN;
            if(col<N-1 && !visit[row][col+1])dfs(row,col+1,TN);
            if(row<N-1 && !visit[row+1][col])dfs(row+1,col,TN);
            if(row>0 && !visit[row-1][col])dfs(row-1,col,TN);
            if(col>0 && !visit[row][col-1])dfs(row,col-1,TN);
        }
        visit[row][col] = true;

    }

}

