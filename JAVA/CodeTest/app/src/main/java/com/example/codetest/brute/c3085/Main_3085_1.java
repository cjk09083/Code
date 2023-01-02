package com.example.codetest.brute.c3085;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main_3085_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] xArr = new char[n][n];
        char[][] xArr1 = new char[n][n];
        char[][] xArr2 = new char[n][n];
        char[][] yArr1 = new char[n][n];
        char[][] yArr2 = new char[n][n];

        for (int i = 0; i < n; i++){
            xArr[i] = br.readLine().toCharArray();
            System.arraycopy(xArr[i], 0, xArr1[i], 0, n);
            System.arraycopy(xArr[i], 0, xArr2[i], 0, n);
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(chkCon(n, xArr, xArr, xArr, xArr, false));

        for (int i = 0; i < n; i++){
            for (int j = 1; j < n; j++) {
                System.out.println("X arr["+i+"]["+j+"]");
                for (int k = 0; k < n; k++){
                    System.arraycopy(xArr[k], 0, xArr1[k], 0, n);
                    System.arraycopy(xArr[k], 0, xArr2[k], 0, n);
                }

                xArr1[i][j-1] = xArr[i][j];
                xArr1[i][j] = xArr[i][j-1];

                xArr2[j-1][i] = xArr[j][i];
                xArr2[j][i] = xArr[j-1][i];

                for (int k = 0; k < n; k++){
                    for (int m = 0; m < n; m++) {
                        yArr1[m][k] = xArr1[k][m];
                        yArr2[m][k] = xArr2[k][m];
                    }
                }

                for (int k = 0; k < n; k++){
                    System.out.println(
                            Arrays.toString(xArr[k])+"   "
                            + Arrays.toString(xArr1[k])+"   "
                            + Arrays.toString(yArr1[k])+"   "
                            + Arrays.toString(xArr2[k])+"   "
                            + Arrays.toString(yArr2[k])+"   "
                    );
                }

                result.add(chkCon(n, xArr1,xArr2,yArr1,yArr2,true));
                System.out.println("result: "+result+"\n");

            }
        }

        System.out.println(result);
        int max = Collections.max(result);
        System.out.println(max);

        br.close();

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
    }

    private static int chkCon(int n, char[][] arr1, char[][] arr2,
                              char[][] arr3, char[][] arr4, boolean full) {

        int con = 1;
        int result = 0;
        for (int i = 0; i < n; i++){
            con = 1;
            char[] rows = arr1[i];
//            System.out.println("rows1["+i+"]: "+Arrays.toString(rows));
            for (int j = 1; j < n; j++){
                if(rows[j] == rows[j-1]) {
                    con++;
                    if(con > result) {
                        System.out.println("rows1["+i+"]["+j+"]: "
                                +Arrays.toString(rows)+" = "+con);
                        result = con;
                    }
                }
                else con = 1;
            }

            if(full) {
                con = 1;
                rows = arr2[i];
                for (int j = 1; j < n; j++) {
                    if (rows[j] == rows[j - 1]) {
                        con++;
                        if (con > result) {
                            System.out.println("rows2[" + i + "][" + j + "]: "
                                    + Arrays.toString(rows) + " = " + con);
                            result = con;
                        }
                    } else con = 1;
                }

                con = 1;
                rows = arr3[i];
                for (int j = 1; j < n; j++) {
                    if (rows[j] == rows[j - 1]) {
                        con++;
                        if (con > result) {
                            System.out.println("rows3[" + i + "][" + j + "]: "
                                    + Arrays.toString(rows) + " = " + con);
                            result = con;
                        }
                    } else con = 1;
                }

                con = 1;
                rows = arr4[i];
                for (int j = 1; j < n; j++) {
                    if (rows[j] == rows[j - 1]) {
                        con++;
                        if (con > result) {
                            System.out.println("rows4[" + i + "][" + j + "]: "
                                    + Arrays.toString(rows) + " = " + con);
                            result = con;
                        }
                    } else con = 1;
                }

            }

        }
        return result;
    }
}

