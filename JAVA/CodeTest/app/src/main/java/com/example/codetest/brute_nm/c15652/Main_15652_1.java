package com.example.codetest.brute_nm.c15652;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_15652_1 {
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

//        System.out.println("n: "+n+", m: "+m );
        ArrayList<Integer> set = new ArrayList<>();
        dfs(1, set);

        System.out.print(sb);
        br.close();
    }


    private static void dfs(int index, ArrayList<Integer> set) {
        if(index == m+1) {
            if (set.size() == m) {
                for (int i : set) sb.append(i).append(" ");
                sb.append('\n');
            }
            return;
        }

        int first = 0;
        if(set.iterator().hasNext()) first = Collections.max(set);

        for(int i=1; i <= n; i++) {
            if(i >= first) {
                set.add(i);
                dfs(index + 1, set);
                set.remove(index - 1);
            }
        }
    }
}

