package com.example.codetest.brute_recursive.c14889;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_14889_1 {

    static int n, result = 99999999;
    static int[][] numArr;
    static int[] team1, team2, visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        numArr = new int[n][n];
        visit = new int[n];
        team1 = new int[n/2]; // n은 무조건 짝수
        team2 = new int[n/2];
        for (int i = 0; i < n; i++){
            String[] strArr = br.readLine().split(" ");
            for (int j = 0; j < n; j++) numArr[i][j] = Integer.parseInt(strArr[j]);
        }

        getResult(0,0);
        System.out.println(result);
        br.close();
    }

    private static void getResult(int index, int start1) {
        if(index == n/2) {
            int pos = 0;
            for (int i = 0; i < n; i++) {
                boolean add = true;
                for(int j = 0; j < n/2; j++){
                    if (team1[j] == i) {
                        add = false;
                        break;
                    }
                }
                if(add){
                    team2[pos] = i;
                    pos++;
                    if(pos == n/2) break;
                }
            }
            int sum1 = 0;
            int sum2 = 0;
            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < n / 2; j++) {
                    if (i != j) {
                        sum1 += numArr[team1[i]][team1[j]];
                        sum2 += numArr[team2[i]][team2[j]];
                    }
                }
            }
            result = Math.min(result, Math.abs(sum1 - sum2));
        }else{
            for (int i = start1; i < n; i++) {
                if (visit[i] == 0) {
                    visit[i] = 1;
                    team1[index] = i;
                    getResult(index + 1, i + 1);
                    visit[i] = 0;
                }
            }
        }
    }


}