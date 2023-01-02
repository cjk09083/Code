package com.example.codetest.brute_nm.c18290;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main_18290_1_xx {
    static int n, m, k;
    private static int[][] numArr;
    private static int[][] visit;

    static boolean debug = true;
    private static ArrayList<Integer> resultArr;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);
        resultArr = new ArrayList<>();
        numArr = new int[m+2][n+2];
        visit = new int[m+2][n+2];
        for (int i = 0; i < m; i++){
            String[] strArr = br.readLine().split(" ");
            for (int j = 0; j < n; j++) numArr[i+1][j+1] = Integer.parseInt(strArr[j]);
        }

        if(debug) {
            System.out.println("m: " + m + ", n: " + n + ", k: " + k);
            for (int i = 0; i < m+2; i++) System.out.println(Arrays.toString(numArr[i]));
            System.out.println();
        }

        ArrayList<Integer> set = new ArrayList<>();
        String selStr = "";
        dfs(0, set, selStr);

        if(debug)System.out.println(resultArr);
        System.out.println(Collections.max(resultArr));

        br.close();
    }

    private static void dfs(int index, ArrayList<Integer> set, String selStr) {
        if(index == k) {
            int sum = 0;
            for(int val : set)
                sum += val;
            resultArr.add(sum);
            if(debug){
//                for (int i = 0; i < m+2; i++) System.out.println(Arrays.toString(visit[i]));
                System.out.println("sum: "+sum);
                System.out.println(selStr);
            }
        }else{
/*
2 2 2
1 2
3 4

3 2 2
1 2 4
8 16 32
 */
            String origin = selStr;
            for (int j = 1; j<=m; j++){
                for (int i =1; i <= n; i++){
                    if(visit[j][i] == 0) {
                        visit[j][i] ++;
                        visit[j-1][i] ++;
                        visit[j+1][i] ++;
                        visit[j][i-1] ++;
                        visit[j][i+1] ++;

                        if(debug) {
                            System.out.println("select: ["+j+"]["+i+"] = "+numArr[j][i]
                                    + ", visit: "+visit[j][i] );
                            for (int k = 0; k < m+2; k++) System.out.println(Arrays.toString(visit[k]));
                            selStr += "select"+index+": ["+j+"]["+i+"] = "+numArr[j][i]+"\n";
                        }

                        set.add(numArr[j][i]);
                        dfs(index + 1,set, selStr);
                        selStr = origin;


                        set.remove(set.size()-1);
                        visit[j][i]--;
                        visit[j-1][i]--;
                        visit[j+1][i]--;
                        visit[j][i-1]--;
                        visit[j][i+1]--;
                        if(debug){
                            System.out.println("remove: ["+j+"]["+i+"]");
//                            for (int k = 0; k < m+2; k++) System.out.println(Arrays.toString(before[k]));
                            for (int k = 0; k < m+2; k++) System.out.println(Arrays.toString(visit[k]));
                            System.out.println();
                        }
                    }
                }
            }
        }
    }

}

