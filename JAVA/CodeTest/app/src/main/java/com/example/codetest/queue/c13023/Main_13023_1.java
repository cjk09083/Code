package com.example.codetest.queue.c13023;
// https://loosie.tistory.com/509

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_13023_1 {
    static boolean status = false;
    static List<Integer>[] list;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n];
        for(int i=0; i<n; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for(int i=0; i<n; i++) {
            check = new boolean[n];
            dfs(i,1);
            if(status) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    static void dfs(int idx, int depth) {
        if(depth==5) {
            status=true;
            return;
        }
        for(int nxt : list[idx]) {
            if(!check[nxt]) {
                check[nxt] = true;
                dfs(nxt, depth+1);
                check[nxt] = false;
            }
        }
    }
}

/*
5 5
0 1
1 2
1 3
2 3
3 4

*/