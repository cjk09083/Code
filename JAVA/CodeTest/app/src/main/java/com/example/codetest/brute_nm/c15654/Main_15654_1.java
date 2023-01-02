package com.example.codetest.brute_nm.c15654;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_15654_1 {
    static StringBuilder sb = new StringBuilder();
    static String[] list;
    static int n, m;
    private static int[] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new int[n];
        list = br.readLine().split(" ");

        map = Arrays.stream(list).mapToInt(Integer::new).toArray();
        Arrays.sort(map);

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

        for(int i=0; i < n; i++) {
            int num = map[i];
            if(!set.contains(num)) {
                set.add(num);
                dfs(index + 1, set);
                set.remove(index - 1);
            }
        }
    }
}

