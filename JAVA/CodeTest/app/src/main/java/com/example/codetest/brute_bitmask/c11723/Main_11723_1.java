package com.example.codetest.brute_bitmask.c11723;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_11723_1 {

    static int N;
    static ArrayList<Integer> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        int x = 0;

        for (int i=0; i<N; i++){
            String[] str = br.readLine().split(" ");
            String cmd = str[0];
            if(str.length > 1) x = Integer.parseInt(str[1]);
            sol(cmd,x);
        }
    }

    private static void sol(String cmd, int x) {
        switch (cmd){
            case "add":
                if(!list.contains(x)) list.add(x);
                break;

            case "remove":
                if(list.contains(x)) list.remove((Integer) x);
                break;

            case "toggle":
                if(list.contains(x)) list.remove((Integer) x);
                else list.add(x);
                break;

            case "empty":
                list.clear();
                break;

            case "all":
                list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,
                        11,12,13,14,15,16,17,18,19,20));
                break;

            case "check":
                if(list.contains(x)) System.out.println(1);
                else System.out.println(0);
                break;
        }
    }
}
