package com.example.codetest.queue.c11724;
// https://m.blog.naver.com/lm040466/221787478911

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11724_1 {
    static int[][] check = new int[1001][1001]; //간선 연결상태
    static boolean[] checked = new boolean[1001]; //확인 여부
    static int n, m, con = 0; // 연결성분 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            check[x][y] = check[y][x] = 1;
        }

        for(int i=1; i<=n; i++) {
            if(!checked[i]) {
                dfs(i);
                con++;
            }
        }
        System.out.println(con);
    }

    static void dfs(int idx) {
        if(checked[idx]) {
            return;
        }
        checked[idx] = true;
        for(int i=1; i<=n; i++) {
            if(!checked[i] && check[idx][i] == 1) {
                dfs(i);
            }
        }
    }

}

