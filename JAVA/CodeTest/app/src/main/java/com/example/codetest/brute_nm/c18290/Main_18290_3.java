package com.example.codetest.brute_nm.c18290;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_18290_3 {
    static int n, m, k, result = -100000;
    private static int[][] numArr;
    private static int[][] visit;
    private static int[] sumArr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);

        numArr = new int[n][m];
        visit = new int[n][m];
        sumArr = new int[k];

        for (int i = 0; i < n; i++){
            String[] strArr = br.readLine().split(" ");
            for (int j = 0; j < m; j++) numArr[i][j] = Integer.parseInt(strArr[j]);
        }

//        System.out.println("m: " + m + ", n: " + n + ", k: " + k);
//        for (int i = 0; i < m+2; i++) System.out.println(Arrays.toString(numArr[i]));
//        System.out.println();

        dfs(0);
        System.out.println(result);

    }

    private static void dfs(int index) {
        if(index == k) {
            int temp = 0;
            for (int i : sumArr) {
                temp += i;
            }
            result = Math.max(result, temp);
        }else{
            for (int i = 0; i < n; i++){
                for (int j =0; j < m; j++){
                    if(visit[i][j] == 0) {
                        go(i, j);
                        sumArr[index] = numArr[i][j]; //현재값 넣기
                        dfs(index + 1);
                        back(i, j);
                    }
                }
            }
        }
    }

    private static void go(int x, int y) {
        visit[x][y] ++;
        if (y-1 >= 0) visit[x][y-1]++;
        if (x-1 >= 0) visit[x-1][y]++;
        if (y+1 < m) visit[x][y+1]++;
        if (x+1 < n) visit[x+1][y]++;
    }

    private static void back(int x, int y) {
        visit[x][y] --;
        if (y-1 >= 0) visit[x][y-1]--;
        if (x-1 >= 0) visit[x-1][y]--;
        if (y+1 < m) visit[x][y+1]--;
        if (x+1 < n) visit[x+1][y]--;
    }
}

