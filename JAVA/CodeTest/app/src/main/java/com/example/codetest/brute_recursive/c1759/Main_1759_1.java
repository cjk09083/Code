package com.example.codetest.brute_recursive.c1759;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1759_1 {

    static StringBuilder sb = new StringBuilder();
    static int n, m;
    private static char[] strArr;
    private static char[] set;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        set = new char[n];
        strArr = new char[m];

        char[] str = br.readLine().toCharArray();

        for (int j = 0; j < m; j++) strArr[j] = str[j*2];

        Arrays.sort(strArr);

        DFS(0,0);
        System.out.println(sb);

        br.close();
    }

    private static void DFS(int start, int index) {
        if(index == n) {
            if(isValid()) {
                for (char i : set) sb.append(i);
                sb.append('\n');
            }
        }else{
            for (int i = start; i < m; i++){
                set[index] = strArr[i];
                DFS(i+1, index + 1);
            }

        }
    }

    public static boolean isValid() {
        int mo = 0;
        int ja = 0;
        for (char x : set) {
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') { mo++; }
            else { ja++; }
        }
        return (mo >= 1 && ja >= 2);
    }


}

