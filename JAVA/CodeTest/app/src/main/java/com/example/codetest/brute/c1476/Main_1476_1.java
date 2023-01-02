package com.example.codetest.brute.c1476;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1476_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         (1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19)
        String[] str = br.readLine().split(" ");
        int E = Integer.parseInt(str[0]);
        int S = Integer.parseInt(str[1]);
        int M = Integer.parseInt(str[2]);

        int result = 0;

        int max = lcm(15,lcm(28,19));
        if((E == S)&&(S == M)){
            result = E;
        }else{
            int[] inputs = {E,S,M};
            int start = Arrays.stream(inputs).max().getAsInt();
            for (long i=start; i< max;i++){
                boolean a = ((i-E) % 15 == 0);
                boolean b = ((i-S) % 28 == 0);
                boolean c = ((i-M) % 19 == 0);
                if(a && b && c){
                    result = (int) i;
                    break;
                }
            }
        }


        System.out.println(result);
        br.close();
    }


    private static int gcd(int m, int n) {
        return (n==0)? m : gcd(n,m % n);
    }

    private static int lcm(int m, int n) {
        return (m*n) / gcd(m,n);
    }
}

