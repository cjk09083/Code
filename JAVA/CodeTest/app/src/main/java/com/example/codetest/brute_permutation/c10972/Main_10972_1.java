package com.example.codetest.brute_permutation.c10972;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_10972_1 {
    // https://developer-mac.tistory.com/57

    static int N;
    static int[] numArr;
    static boolean debug = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numArr = Arrays.stream(br.readLine().split(" ")).
                mapToInt(Integer::parseInt).toArray();

        if(debug)System.out.println(Arrays.toString(numArr));

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
            if(numArr[i-1] < numArr[i]){

                int j = max;
                while (numArr[j] <= numArr[i - 1]) j--;                 // 스압한 수 다음으로 큰 수 탐색
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
        int[] arr1 = Arrays.stream(
                Arrays.copyOfRange(numArr, idx, numArr.length)).sorted().toArray();
        if(debug)System.out.println("backSort: "+Arrays.toString(arr1));
        for (int i = idx; i < N; i++) numArr[i] = arr1[i-idx];
    }

/*
7
7 2 3 6 5 4 1

7 2 4 6 5 3 1

 */

}
