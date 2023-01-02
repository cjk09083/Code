package com.example.codetest.brute_nm.c15650;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;

public class Main_15650_1 {
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        HashSet<Integer> set = new HashSet<>();
        dfs(1, set);

        System.out.print(sb);
        br.close();
    }


    private static void dfs(int index, HashSet<Integer> set) {
            if(index == m+1) {
                if (set.size() == m) {
                    for (int i : set) sb.append(i).append(" ");
                    sb.append('\n');
                }
                return;
            }

        int first = 0;
        if(set.iterator().hasNext()) first = Collections.max(set);

        for(int i=index; i <= n; i++) {
            if(i > first) {
                set.add(i);
                if (set.size() == index) {
                    dfs(index + 1, set);
                    set.remove(i);
                }
            }
        }
    }
}

