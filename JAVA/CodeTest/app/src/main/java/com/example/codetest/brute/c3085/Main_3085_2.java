package com.example.codetest.brute.c3085;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_3085_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] xArr = new char[n][n];
        char[][] xArr1 = new char[n][n];
        char[][] xArr2 = new char[n][n];
        for (int i = 0; i < n; i++){
            xArr[i] = br.readLine().toCharArray();
            System.arraycopy(xArr[i], 0, xArr1[i], 0, n);
            System.arraycopy(xArr[i], 0, xArr2[i], 0, n);
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(chkCon(n, xArr));

        for (int i = 0; i < n; i++){
            for (int j = 1; j < n; j++) {
                boolean a = (xArr1[i][j-1] != xArr[i][j]), b = (xArr2[j-1][i] != xArr[j][i]);

                if(a){
                    xArr1[i][j-1] = xArr[i][j];
                    xArr1[i][j] = xArr[i][j-1];
                }
                if(b) {
                    xArr2[j - 1][i] = xArr[j][i];
                    xArr2[j][i] = xArr[j - 1][i];
                }
                if(a || b) {
                    if(a)result.add(chkCon(n, xArr1));
                    if(b)result.add(chkCon(n, xArr2));

                    if(a){
                        xArr1[i][j-1] = xArr[i][j-1];
                        xArr1[i][j] = xArr[i][j];
                    }
                    if(b) {
                        xArr2[j - 1][i] = xArr[j-1][i];
                        xArr2[j][i] = xArr[j][i];
                    }
                }
            }
        }

        int max = Collections.max(result);
        System.out.println(max);

        br.close();

    }

/*
2
CP
CP

3
CCP
CCP
PPC

4
PCPP
CYZY
CCPY
PPCC

5
YCPZY
CYZZP
CCPPP
YCYZC
CPPZZ
*/
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
