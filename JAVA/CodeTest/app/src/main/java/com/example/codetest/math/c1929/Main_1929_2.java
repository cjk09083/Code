package com.example.codetest.math.c1929;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1929_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int start = Integer.parseInt(str[0]);
        int end = Integer.parseInt(str[1]);

        int max = 1000000;
        int[] f = new int[max+1];        //f(n)

        f[1] = 1;

        StringBuilder sb = new StringBuilder();
        double sqrt = Math.sqrt(end);
        for(int i=2; i <= end; i++){
            if(i <= sqrt) {
                for (int j = 2; j * i <= max; j++) {
                    f[j * i] = 1;
                }
            }
            if(f[i]==0 && i>=start) sb.append(i).append('\n');
        }
        System.out.println(sb);

        br.close();
    }
}


