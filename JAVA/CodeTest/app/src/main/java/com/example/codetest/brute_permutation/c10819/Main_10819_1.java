package com.example.codetest.brute_permutation.c10819;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_10819_1 {

    static int n, result;
    static int[] arr, setArr;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n =  Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).
                mapToInt(Integer::parseInt).toArray();

        Arrays.sort(arr);

        visited =new boolean[n];
        setArr =new int[n]; // 각순열 케이스를 담아줄 임시 저장소

        result=0;
        sol(0);
        System.out.println(result);
    }

    private static void sol(int depth){
        if(depth == n){
            int sum =0;
            for (int i = 0; i <n-1 ; i++) {
                sum += Math.abs(setArr[i] - setArr[i+1]);
            }
            result = Math.max(result,sum);
            return;
        }

        for (int i = 0; i <n ; i++) { // 각순열 케이스생성
            if(!visited[i]) {
                visited[i] = true;
                setArr[depth] = arr[i];
                sol(depth + 1);
                visited[i] = false;
            }
        }
    }
}
