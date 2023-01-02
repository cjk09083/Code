package com.example.codetest.math.c1978;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1978_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int c = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");

        int max = 1000;
        int[] f = new int[max+1];        //f(n)

        f[1] = 1;

        for(int i=2; i <= Math.sqrt(max); i++){
            for (int j = 2; j*i <= max; j++){
//                System.out.println("i: "+i+", j: "+j+", i*j: "+(i*j));
                f[j*i] = 1;
            }
        }

        int result = 0;
        for(int i=0; i<c; i++){
            int n = Integer.parseInt(str[i]);
            if(f[n]==0) result++;
        }
        System.out.println(result);

        br.close();
    }
}


