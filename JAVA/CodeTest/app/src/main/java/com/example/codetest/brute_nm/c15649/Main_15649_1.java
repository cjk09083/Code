package com.example.codetest.brute_nm.c15649;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_15649_1 {

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] list = new int[n];
        for (int i = 0; i < n; i++) list[i] = i+1;

        ArrayList<Integer> set = new ArrayList<>();
        dfs(list, n, m, set, m);
        System.out.println(sb);
        br.close();
    }


    private static void dfs(int[] list, int n, int r, ArrayList<Integer> set, int m) {
        if(r==0) {
            if (set.size()==m) {
                for (int i : set) {
                    sb.append(i).append(" ");
                }
                sb.append('\n');
            }
            return;
        }

        for(int i=0; i < n; i++) {
            boolean add = (!set.contains(list[i]));
            if (add) {
                set.add(list[i]);
                dfs(list, n, r - 1, set, m);
                set.remove(set.size()-1);
            }
        }
    }
}

