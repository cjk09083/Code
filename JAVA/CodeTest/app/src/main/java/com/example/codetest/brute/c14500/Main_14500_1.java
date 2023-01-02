package com.example.codetest.brute.c14500;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_14500_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int row = Integer.parseInt(str[0]);
        int col = Integer.parseInt(str[1]);
        int[][] numArr = new int[row+6][col+6];
        for (int i = 0; i < row; i++){
            String[] strArr = br.readLine().split(" ");
            for (int j = 0; j < col; j++) numArr[i+3][j+3] = Integer.parseInt(strArr[j]);
        }

        System.out.println("row: "+row+", col: "+col);
        Arrays.stream(numArr).forEach((arr)->System.out.println(Arrays.toString(arr)));
        System.out.println();

        int result = 0;

        for (int i = 0; i < row+3; i++) {
            for (int j = 0; j < col+3; j++) {
                int anw = solution(numArr, i, j);
                System.out.println("result["+i+"]["+j+"]: "+anw);
                result = Math.max(result, anw);
            }
        }

        System.out.println(result);

        br.close();
    }

    private static int solution(int[][] array, int a, int b) {
        int result = 0;
        int sum;

        // 1 직선 (세로 놓기)ㄴ                                                                            s
        sum = array[a][b] + array[a+1][b] + array[a+2][b] + array[a+3][b];                          // 2
        result = Math.max(result, sum);                                                             // 3
                                                                                                    // 4
        // 2 직선 (가로 놓기)
        sum = array[a][b] + array[a][b+1] + array[a][b+2] + array[a][b+3];                          // s 2 3 4
        result = Math.max(result, sum);

        // 3 네모
        sum = array[a][b] + array[a+1][b] + array[a+1][b+1] + array[a][b+1];                        // s 4
        result = Math.max(result, sum);                                                             // 2 3

        // 4 ㄴ  // 왼상단시작 오른 하단 종료. (반시계방향)ㄴ                                                    s
        sum = array[a][b] + array[a+1][b] + array[a+2][b] + array[a+2][b+1];                        // 2
        result = Math.max(result, sum);                                                             // 3 4

        // 5 ㄴ case // 왼상단시작 오른 하단 종료. (반시계방향)의 대칭.                                           s 1
        sum = array[a][b+1] + array[a+1][b+1] + array[a+2][b+1] + array[a+2][b];                    //   2
        result = Math.max(result, sum);                                                             // 4 3

        // 6 ㄴ  // 왼하단시작 오른 상단 종료
        sum = array[a+1][b] + array[a][b] + array[a][b+1] + array[a][b+2];                          // s 3 4
        result = Math.max(result, sum);                                                             // 1

        // 7 ㄴ  // 왼하단시작 오른 상단 종료.
        sum = array[a][b] + array[a][b+1] + array[a][b+2] + array[a+1][b+2];                        // s 2 3
        result = Math.max(result, sum);                                                             //     4

        // 8 ㄴ  // 왼상단시작 오른 하단 종료 (시계방향)                                                        s 2
        sum = array[a][b] + array[a][b+1] + array[a+1][b+1] + array[a+2][b+1];                      //   3
        result = Math.max(result, sum);                                                             //   4

        // 9 ㄴ  // 왼상단시작 오른 하단 종료 (시계방향) 의 대칭                                                  s 1
        sum = array[a][b+1] + array[a][b] + array[a+1][b] + array[a+2][b];                          // 3
        result = Math.max(result, sum);                                                             // 4

        // 10 ㄴ  // 오른 상단시작  왼 하단 종료 ??
        sum = array[a][b+2] + array[a+1][b+2] + array[a+1][b+1] + array[a+1][b];                    // s   1
        result = Math.max(result, sum);                                                             // 4 3 2

        // 11 ㄴ  // 오른 상단시작  왼 하단 종료 의 대칭
        sum = array[a][b] + array[a+1][b] + array[a+1][b+1] + array[a+1][b+2];                      // s
        result = Math.max(result, sum);                                                             // 2 3 4

        // 12 ㄴㄱ  // 왼상단시작 오른 하단 종료                                                              s
        sum = array[a][b] + array[a+1][b] + array[a+1][b+1] + array[a+2][b+1];                      // 2 3
        result = Math.max(result, sum);                                                             //   4

        // 13 ㄴㄱ  // 오른 상단시작  하단 종료
        sum = array[a][b+2] + array[a][b+1] + array[a+1][b+1] + array[a+1][b];                      // s 2 1
        result = Math.max(result, sum);                                                             // 4 3

        // 14 ㄴㄱ  // 왼하단시작 오른 상단 종료.                                                             s 4
        sum = array[a+2][b] + array[a+1][b] + array[a+1][b+1] + array[a][b+1];                      // 2 3
        result = Math.max(result, sum);                                                             // 1

        // 15 ㄴㄱ  // 왼상단시작 오른 하단 종료.  (ㄱㄴ꼴) ..
        sum = array[a][b] + array[a][b+1] + array[a+1][b+1] + array[a+1][b+2];                      // s 2
        result = Math.max(result, sum);                                                             //   3 4

        // 16 ㅗ   //  ㅜ
        sum = array[a][b] + array[a][b+1] + array[a][b+2] + array[a+1][b+1];                        // s 2 3
        result = Math.max(result, sum);                                                             //   4

        // 17 ㅗ   // ㅓ                                                                                s 1
        sum = array[a][b+1] + array[a+1][b+1] + array[a+2][b+1] + array[a+1][b];                    // 4 2
        result = Math.max(result, sum);                                                             //   3

        // 18 ㅗ   //  ㅗ
        sum = array[a+1][b] + array[a+1][b+1] + array[a+1][b+2] + array[a][b+1];                    // s 4
        result = Math.max(result, sum);                                                             // 1 2 3

        // 19 ㅗ   //  ㅏ                                                                               s
        sum = array[a][b] + array[a+1][b] + array[a+2][b] + array[a+1][b+1];                        // 2 4
        result = Math.max(result, sum);                                                             // 3

        return result;
    }

}

