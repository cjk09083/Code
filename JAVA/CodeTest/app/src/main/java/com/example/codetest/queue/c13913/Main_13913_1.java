package com.example.codetest.queue.c13913;

// https://velog.io/@leeinae/Algorithm-%EB%B0%B1%EC%A4%801697-%EC%88%A8%EB%B0%94%EA%BC%AD%EC%A7%88

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_13913_1 {
    static int N,K;
    static int[] visited = new int[100001];
    static int[] parent = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bfs();

        Stack<Integer> stack = new Stack<>();
        stack.push(K);
        int index = K;

        while (index != N) {
            stack.push(parent[index]);
            index = parent[index];
        }

        sb.append(visited[K] - 1 + "\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }

        System.out.println(sb);
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        visited[N] = 1;

        while (!q.isEmpty()) {
            int temp = q.poll();
            if (temp == K) return;

            for (int i=0; i<3; i++) {
                int next;

                if (i == 0)         next = temp + 1;
                else if (i == 1)    next = temp - 1;
                else                next = temp * 2;

                if (next >= 0 && next < visited.length && visited[next] == 0) {
                    q.add(next);
                    visited[next] = visited[temp] + 1;
                    parent[next] = temp;
                }
            }
        }
    }

}

