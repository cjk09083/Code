package com.example.codetest.brute_nm.c15650;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main_15650_2 {
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static HashSet<String> resultSet = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

//        System.out.println("n: "+n+", m: "+m );
        HashSet<Integer> set = new HashSet<>();
        dfs(1, set);

        resultSet.stream().sorted().forEach(System.out::println);

        br.close();
    }


    private static void dfs(int index, HashSet<Integer> set) {
            if (set.size()==m) {
                sb = new StringBuilder();
                for (int i : set) sb.append(i).append(" ");
                resultSet.add(sb.toString());
                return;
            }


        for(int i=index; i <= n; i++) {
            if(!set.contains(i)){
//                System.out.print("n: "+n+", idx: "+index+", add: "+i+" to set: "+set);
                set.add(i);
//                System.out.println(", result: "+set);
                dfs( index+1, set);
            }
            set.remove(i);
        }
    }
}

