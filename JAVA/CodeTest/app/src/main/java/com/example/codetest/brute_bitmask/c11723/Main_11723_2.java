package com.example.codetest.brute_bitmask.c11723;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_11723_2 {

    static StringBuilder sb;
    static int N;
    static boolean[] list, all;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        list = new boolean[21];
        all = new boolean[21];
        sb = new StringBuilder();

        for (int i =1; i<21; i++)all[i] = true;
        int x = 0;

        for (int i=0; i<N; i++){
            String[] str = br.readLine().split(" ");
            String cmd = str[0];
            if(str.length > 1) x = Integer.parseInt(str[1]);
            sol(cmd,x);
        }
        System.out.println(sb);
    }

    private static void sol(String cmd, int x) {
        switch (cmd){
            case "add":
                list[x]=true;
                break;

            case "remove":
                list[x]=false;
                break;

            case "toggle":
                list[x] = !list[x];
                break;

            case "empty":
                list = new boolean[21];
                break;

            case "all":
                list = all.clone();
                break;

            case "check":
                if(list[x]) sb.append(1).append("\n");
                else sb.append(0).append("\n");
                break;
        }
    }
}
