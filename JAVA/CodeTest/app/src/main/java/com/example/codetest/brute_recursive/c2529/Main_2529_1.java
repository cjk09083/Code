package com.example.codetest.brute_recursive.c2529;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_2529_1 {

    static String[] arrows;
    static String minStr="", maxStr="";
    static int n;
    static long min,max;
    static ArrayList<Integer> numList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arrows = new String[n];
        max = Long.MIN_VALUE;
        min = Long.MAX_VALUE;
        numList = new ArrayList<>();

        arrows = br.readLine().split(" ");

        sol(0);
        minStr = String.valueOf(min);
        maxStr = String.valueOf(max);

        maxStr = makeStr(maxStr);
        minStr = makeStr(minStr);

        System.out.println(maxStr);
        System.out.println(minStr);
    }

    private static String makeStr(String value) {
        StringBuilder zeros = new StringBuilder();
        int target = (n+1) - value.length();
        for (int i=0; i < target; i++){
            zeros.append("0");
        }
        value = zeros+value;
        return value;
    }

    public static void sol(int depth) {
        if(depth == n + 1) {
            StringBuilder number = new StringBuilder();
            for(int i=0;  i< n+1; i++) number.append(numList.get(i));
            long result = Long.parseLong(number.toString());
            min = Math.min(min, result);
            max = Math.max(max, result);
            return;
        }

        for(int i=0; i<10; i++) {
            if(!numList.contains(i)) {
                if(depth == 0){
                    numList.add(i);
                    sol(depth+1);
                    numList.remove(numList.size()-1);
                } else {
                    boolean moreArrow = (arrows[depth-1].equals("<"));
                    if ( (moreArrow && numList.get(depth - 1) < i)
                        || (!moreArrow && numList.get(depth - 1) > i)
                    ){
                        numList.add(i);
                        sol(depth + 1);
                        numList.remove(numList.size() - 1);
                    }
                }
            }
        }
    }

}