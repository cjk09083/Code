package com.example.codetest.brute_bitmask.c1182;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1182_1 {

    static int N, S, count=0;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        S = Integer.parseInt(str[1]);
        arr = new int[N];
        str = br.readLine().split(" ");
        for (int i=0; i<N; i++) arr[i] =  Integer.parseInt(str[i]);

        dfs(0,0);

        // count 합이 0인 경우 공집합도 포함되므로 그 수를 하나 빼주고 출력
        if(S==0) count--;
        System.out.println(count);
    }

    private static void dfs(int idx, int sum) {
        // dfs로 돌며 누적시키다가 위치를 나타내는 v이 마지막 위치로 오면 원하는 값인지 아닌지 체크하여 count
        if(idx == N){
            if(sum == S)count++;
            return;
        }
        // 부분수열, 지금 위치의 원소를 선택하거, 선택하지 않거나
        dfs(idx+1, sum+arr[idx]); // 지금 위치의 원소를 선택
        dfs(idx+1, sum); // 선택하지 않음.
    }
}
