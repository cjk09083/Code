package com.example.codetest.brute_nm.c15654;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_15654_2 {
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    private static int[] map;
    private static int[] result;
    private static boolean[] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new int[n];
        result = new int[m];
        visit = new boolean[n+1];
        String[] list = br.readLine().split(" ");

        map = Arrays.stream(list).mapToInt(Integer::new).sorted().toArray();

        dfs(0);

        System.out.print(sb);
        br.close();
    }


    private static void dfs(int index) {
        if(index == m) {
            for (int i : result) sb.append(i).append(" ");
            sb.append('\n');
        }else {
            for (int i=0; i<n; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    result[index] = map[i];
                    dfs(index+1);
                    visit[i] = false;
                }
            }
        }
    }
}

