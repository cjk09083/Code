package com.example.codetest.brute_permutation.c10971;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10971_3 {
    static int n, result = Integer.MAX_VALUE;
    private static int[][] numArr;
    private static boolean[] visit;
    private static int[] sumArr, posArr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);

        numArr = new int[n+1][n+1];
        visit = new boolean[n+1];
        posArr = new int[n+1];
        sumArr = new int[n+1];

        for (int i = 0; i < n; i++){
            String[] strArr = br.readLine().split(" ");
            for (int j = 0; j < n; j++) numArr[i+1][j+1] = Integer.parseInt(strArr[j]);
        }

//        for (int i=0;i<n;i++) System.out.println(Arrays.toString(numArr[i+1]));

        visit[1] = true;
        posArr[0] = 1;
        sol(1,1,1);

        System.out.println(result);

    }

    private static void sol(int depth, int start, int now){

        if(depth == n+1){
            int sum = 0;
            for (int i : sumArr) sum += i;
            result = Math.min(result, sum);
            return;
        }

        for (int j = 1; j <= n ; j++) {
            if (numArr[now][j] > 0) {
                if (j == start && depth == n) {
                    posArr[depth] = j;
                    sumArr[depth] = numArr[now][j];
                    sol(depth + 1,start,j);
                }

                else if (!visit[j]) {
                    visit[j] = true;
                    posArr[depth] = j;
                    sumArr[depth] = numArr[now][j];
                    sol(depth + 1,start,j);
                    visit[j] = false;
                }
            }
        }
    }
}
