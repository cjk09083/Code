package com.example.codetest.queue.c13549;

// https://velog.io/@leeinae/Algorithm-%EB%B0%B1%EC%A4%801697-%EC%88%A8%EB%B0%94%EA%BC%AD%EC%A7%88

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_13549_2 {
    static int N,K;
    static int[] visited = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        K = Integer.parseInt(str[1]);
        bfs();
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        visited[N] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0)         next = now + 1;
                else if (i == 1)    next = now - 1;
                else                next = now * 2;

                if (next >= 0 && next < visited.length) {
                    if(i < 2 && (visited[next] == 0 || visited[next] > visited[now]+1)) {
                        q.add(next);
                        visited[next] = visited[now] + 1;
                    }  else if (i == 2 && (visited[next] == 0 || visited[next] > visited[now])) {
                        q.add(next);
                        visited[next] = visited[now];
                    }
                }
            }
        }
        System.out.println(visited[K]-1);
    }

}

