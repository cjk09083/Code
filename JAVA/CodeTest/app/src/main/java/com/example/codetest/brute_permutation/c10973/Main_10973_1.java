package com.example.codetest.brute_permutation.c10973;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_10973_1 {

    static int N;
    static int[] numArr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numArr = Arrays.stream(br.readLine().split(" ")).
                mapToInt(Integer::parseInt).toArray();

        if(sol()){
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < N; j++) sb.append(numArr[j]).append(" ");
            System.out.println(sb);
        }else{
            System.out.println("-1");
        }
    }

    private static boolean sol() {
        int max = numArr.length - 1;
        for (int i = max; i > 0; i--) {
            if(numArr[i-1] > numArr[i]){

                int j = max;
                while (numArr[j] >= numArr[i - 1]) j--;
                swap(i - 1, j);

                backSort(i);
                return true;
            }
        }
        return false;
    }

    private static void swap(int idx1, int idx2) {
        int temp = numArr[idx1];
        numArr[idx1] = numArr[idx2];
        numArr[idx2] = temp;
    }

    private static void backSort(int idx) {
        int[] arr1 = Arrays.copyOfRange(numArr, idx, numArr.length);

        for(int i=0; i<arr1.length; i++) {
            for(int j=i+1; j<arr1.length; j++) {
                if(arr1[i] < arr1[j]) {
                    int tmp = arr1[i];
                    arr1[i] = arr1[j];
                    arr1[j] = tmp;
                }
            }
        }
        for (int i = idx; i < N; i++) numArr[i] = arr1[i-idx];
    }

/*
7
1 4 5 6 2 3 7
 */

}
