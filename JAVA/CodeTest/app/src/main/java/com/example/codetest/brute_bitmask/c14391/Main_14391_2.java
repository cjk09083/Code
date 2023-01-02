package com.example.codetest.brute_bitmask.c14391;
/*
https://machine-geon.tistory.com/153
1. dfs로 탐색 (row, col).
2. 가로 숫자 = true, 세로 숫자 = false 활용.
3. 열을 이동하며 가로,세로를 체크('true' or 'false').
4. 해당 행의 모든열을 체크한 경우 다음 행을 재귀 호출.
5. 기저 조건 (모든 맵을 탐색한 경우) 만들어진 수를 계산.
6. 세로와 가로의 덧셈을 할때, 수의 자리(1의 자리 or 10의 자리) 신경을 쓴다.
7. 최댓값과 비교후 갱신.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14391_2 {

    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static int max = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        dfs(0, 0);
        System.out.println(max);
    }

    private static void dfs(int row, int col) {
        if (row >= N) sum();
        else if (col >= M) dfs(row + 1, 0);                       // 하나의 행의 체크 종료 -> 다음 행으로 이동
        else {
            visited[row][col] = true;                                       // 가로 숫자로 사용
            dfs(row, col + 1);
            visited[row][col] = false;                                      // 세로 숫자로 사용
            dfs(row, col + 1);
        }
    }

    private static void sum() {
        int tempRow, tempCol, result = 0;

        for (int i = 0; i < N; i++) {
            tempRow = 0;
            tempCol = 0;
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) {
                    tempRow = tempRow * 10 + map[i][j];
                    result += tempCol;
                    tempCol = 0;
                } else {
                    tempCol = tempCol * 10 + map[j][i];
                    result += tempRow;
                    tempRow = 0;
                }
            }
            result += tempRow + tempCol;
        }

        max = Math.max(max, result);
    }

}
