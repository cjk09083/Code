package com.example.codetest.brute.c1476;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1476_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //(1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19)
        String[] str = br.readLine().split(" ");
        int E = Integer.parseInt(str[0]);
        int S = Integer.parseInt(str[1]);
        int M = Integer.parseInt(str[2]);
        int result = 1;
        int e=1, s=1, m = 1;
        while (true){
            if(e==E && s==S && m==M){
                System.out.println(result);
                break;
            }
            e++; s++; m++;
            if (e > 15) e = 1;
            if (s > 28) s = 1;
            if (m > 19) m = 1;
            result++;
        }

        br.close();
    }

    private static int gcd(int m, int n) {
        return (n==0)? m : gcd(n,m % n);
    }

    private static int lcm(int m, int n) {
        return (m*n) / gcd(m,n);
    }
}

