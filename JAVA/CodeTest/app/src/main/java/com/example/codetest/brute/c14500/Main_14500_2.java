package com.example.codetest.brute.c14500;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_14500_2 {
    // DFS, BFS https://devuna.tistory.com/32
    static int[][] ways = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    //중앙을 중심으로
    static int[][][] special_case = {
            {{-1,0},{1,0},{0,1}}, /* ├  */
            {{0,-1},{0,1},{1,0}},/* ┬ */
            {{0,-1},{-1,0},{1,0}},/* ┤ */
            {{0,-1},{-1,0},{0,1}} /* ┴ */
    };

    static boolean[][] visited ;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int row = Integer.parseInt(str[0]);
        int col = Integer.parseInt(str[1]);
        int[][] numArr = new int[row+3][col+3];
        visited = new boolean[row][col];
        for (int i = 0; i < row; i++){
            String[] strArr = br.readLine().split(" ");
            for (int j = 0; j < col; j++) numArr[i][j] = Integer.parseInt(strArr[j]);
        }

        System.out.println("row: "+row+", col: "+col);
        Arrays.stream(numArr).forEach((arr)->System.out.println(Arrays.toString(arr)));
        System.out.println();

        int result = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result = Math.max(result, solution(numArr, i, j));
            }
        }

        System.out.println(result);
        br.close();
    }

    private static int solution(int[][] arr, int x, int y) {
        //dfs로 4가지 테트로미노 처리
        visited[x][y] = true;
        int result = dfs(arr, x, y, 0, visited);
        visited[x][y] = false;

        //특수 케이스에 대해 결과값 처리
        for (int[][] ways : special_case){
            int val = arr[x][y] ;
            boolean toggle = false;
            for (int[] way : ways){
                int next_x = x + way[0];
                int next_y = y + way[1];
                if (next_x >= 0 && next_x < arr.length && next_y >= 0 && next_y < arr[0].length){
                    val +=arr[next_x][next_y];
                }else{
                    toggle = true;
                    break;
                }
            }
            //하나라도 안되면 다음 모양으로 전환
            if(toggle) continue;

            result = Math.max(result,val);
        }

        return result;
    }

    private static int dfs(int[][] arr, int x, int y, int depths, boolean[][] visited) {
        int res = 0;
        if (depths == 3) return arr[x][y];

        for (int[] way : ways) {
            int next_x = x + way[0];
            int next_y = y + way[1];

            //범위안
            if (next_x >= 0 && next_x < arr.length && next_y >= 0 && next_y < arr[0].length) {
                //미방문
                if (!visited[next_x][next_y]) {
                    visited[next_x][next_y] = true;
                    res = Math.max(res, dfs(arr, next_x, next_y, depths + 1, visited));
                    visited[next_x][next_y] = false;
                }
            }
        }

        return arr[x][y] + res;
    }

}

