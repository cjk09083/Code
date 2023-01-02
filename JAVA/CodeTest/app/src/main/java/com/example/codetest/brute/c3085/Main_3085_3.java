package com.example.codetest.brute.c3085;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_3085_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] numArr = new char[n][n];
        for (int i = 0; i < n; i++){
            numArr[i] = br.readLine().toCharArray();
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(chkCon(n, numArr));
        char left, right;
        char down, up;
        for (int i = 0; i < n; i++){
            for (int j = 1; j < n; j++) {
                boolean a = (numArr[i][j-1] != numArr[i][j]), b = (numArr[j-1][i] != numArr[j][i]);

                if(a){
                    left = String.valueOf(numArr[i][j-1]).toCharArray()[0];
                    right = String.valueOf(numArr[i][j]).toCharArray()[0];
                    numArr[i][j-1] = right;
                    numArr[i][j] = left;
                    result.add(chkCon(n, numArr));
                    numArr[i][j-1] = left;
                    numArr[i][j] = right;
                }

                if(b) {
                    up = String.valueOf(numArr[j-1][i]).toCharArray()[0];
                    down = String.valueOf(numArr[j][i]).toCharArray()[0];
                    numArr[j-1][i] = down;
                    numArr[j][i] = up;
                    result.add(chkCon(n, numArr));
                    numArr[j][i] = down;
                    numArr[j-1][i] = up;
                }
            }
        }

        int max = Collections.max(result);
        System.out.println(max);

        br.close();

    }

    private static int chkCon(int n, char[][] arr) {

        int result = 0;
        for (int i = 0; i < n; i++){
            int row = 1, col = 1;
            for (int j = 0; j < n-1; j++){
                if(arr[i][j] == arr[i][j+1]) {
                    row++;
                    if(row > result) {
                        result = row;
                    }
                }
                else row = 1;

                if(arr[j][i] == arr[j+1][i]) {
                    col++;
                    if(col > result) {
                        result = col;
                    }
                }
                else col = 1;
            }

        }
        return result;
    }
}

