package com.example.codetest.brute_recursive.c14889;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main_14889_2 {

    static int n, result = 99999999;
    static int[][] numArr;
    static int[] visit;
    static List<Integer> team1, team2, total;
    static boolean debug = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        numArr = new int[n][n];
        visit = new int[n];
        team1 = new ArrayList<>(); // n은 무조건 짝수
        team2 = new ArrayList<>();
        total = new ArrayList<>();
        for (int i = 0; i < n; i++){
            total.add(i);
            String[] strArr = br.readLine().split(" ");
            for (int j = 0; j < n; j++) numArr[i][j] = Integer.parseInt(strArr[j]);
        }


        if(debug) {
            for (int i = 0; i < n; i++) System.out.println(Arrays.toString(numArr[i]));
        }

        getResult(0,0);

        System.out.println(result);

        br.close();
    }

    private static void getResult(int index, int start1) {
        if(index == n/2) {
            team2.clear();
            team2.addAll(total);
            team2.removeAll(team1);
            if(debug) System.out.println("index: "+index
                    +", team1: "+team1+", team2: "+team2);

            int sum1 = 0;
            int sum2 = 0;
            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < n / 2; j++) {
                    if (i != j) {
                        sum1 += numArr[team1.get(i)][team1.get(j)];
                        sum2 += numArr[team2.get(i)][team2.get(j)];
//                        if(debug) System.out.println("i: "+i+", j: "+j
//                                +", t1[i]: "+team1[i]+", t1[j]: "+team1[j] +", s1: "+sum1
//                                +", t2[i]: "+team2[i]+", t2[j]: "+team2[j] +", s2: "+sum2);
                    }
                }
            }
            if(debug) System.out.println("index: "+index
                    +", team1: "+team1.toString()+", team2: "+team2.toString()
                    +", sum1: "+sum1  +", sum2: "+sum2
                    +", temp = "+Math.abs(sum1 - sum2));

            result = Math.min(result, Math.abs(sum1 - sum2));
        }else{
            for (int i = start1; i < n; i++) {
                if (visit[i] == 0) {
                    visit[i] = 1;
                    team1.add(i);
//                    System.out.println("index: " + index + ", team1 = " + i);
                    getResult(index + 1, i + 1);
                    visit[i] = 0;
                    team1.remove(team1.size()-1);
                }
            }
        }
    }
}

