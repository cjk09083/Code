package com.example.codetest.math.c6588;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_6588_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int max = 1000000;
        int[] f = new int[max+1];        //f(n)
        int[] g = new int[max+1];        //f(n)
        f[1] = 1;

        int prime_idx = 0;
        for(int i=2; i <= Math.sqrt(max); i++){
            for (int j = 2; j*i <= max; j++){
                f[j*i] = 1;
            }
            if(f[i]==0) {g[prime_idx] = i; prime_idx ++;};
        }

        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n==0)break;
            for(int i=0; i <= max; i++){
                if(f[(n - g[i])] == 0){
                    String result = n +" = " + g[i] + " + "+ (n - g[i]);
                    sb.append(result).append("\n");
                    break;
                }
            }
        }

        System.out.println(sb);
        br.close();
    }
}


