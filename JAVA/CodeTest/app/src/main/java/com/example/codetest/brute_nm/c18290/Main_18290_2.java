package com.example.codetest.brute_nm.c18290;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_18290_2 {
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
        numArr = new int[n+2][m+2];
        visit = new int[n+2][m+2];
        sumArr = new int[k];

        for (int i = 0; i < n; i++){
            String[] strArr = br.readLine().split(" ");
            for (int j = 0; j < m; j++) numArr[i+1][j+1] = Integer.parseInt(strArr[j]);
        }

        dfs(0);
        System.out.println(result);

        br.close();
    }

    private static void dfs(int index) {
        if(index == k) {
            int temp = 0;
            for (int i : sumArr) {
                temp += i;
            }
            result = Math.max(result, temp);
        }else{
            for (int i = 1; i<=n; i++){
                for (int j =1; j <= m; j++){
                    if(visit[i][j] == 0) {
                        visit[i][j] ++;
                        visit[i-1][j] ++;
                        visit[i+1][j] ++;
                        visit[i][j-1] ++;
                        visit[i][j+1] ++;
                        sumArr[index] = numArr[i][j]; //현재값 넣기
                        dfs(index + 1);
                        visit[i][j]--;
                        visit[i-1][j]--;
                        visit[i+1][j]--;
                        visit[i][j-1]--;
                        visit[i][j+1]--;
                    }
                }
            }
        }
    }

}

