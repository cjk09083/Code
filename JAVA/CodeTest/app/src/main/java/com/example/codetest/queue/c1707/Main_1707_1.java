package com.example.codetest.queue.c1707;
// https://jellyinghead.tistory.com/14

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1707_1 {
    static int V, E;
    static ArrayList<Integer>[] list;
    static int[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringTokenizer stz;

        for(int tc = 0; tc < K; tc++) {
            stz = new StringTokenizer(br.readLine());
            V = Integer.parseInt(stz.nextToken());
            E = Integer.parseInt(stz.nextToken());
            visit = new int[V + 1];
            list = new ArrayList[V + 1];

            for(int i = 0; i <= V; i++) list[i] = new ArrayList<>();

            for(int i = 0; i < E; i++) {
                stz = new StringTokenizer(br.readLine());
                int p1 = Integer.parseInt(stz.nextToken());
                int p2 = Integer.parseInt(stz.nextToken());
                list[p1].add(p2);
                list[p2].add(p1);
            }
            bfs();
        }
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= V; i++) {
            if(visit[i] == 0) {
                q.add(i);
                visit[i] = 1;
            }

            while(!q.isEmpty()) {
                int now = q.poll();
                for(int j = 0; j < list[now].size(); j++) {
                    if(visit[list[now].get(j)] == 0) {
                        q.add(list[now].get(j));
                    }

                    if(visit[list[now].get(j)] == visit[now]) {
                        System.out.println("NO");
                        return;
                    }

                    if(visit[now] == 1 && visit[list[now].get(j)] == 0)
                        visit[list[now].get(j)] = 2;
                    else if(visit[now] == 2 && visit[list[now].get(j)] == 0)
                        visit[list[now].get(j)] = 1;
                }
            }
        }
        System.out.println("YES");
    }

}

