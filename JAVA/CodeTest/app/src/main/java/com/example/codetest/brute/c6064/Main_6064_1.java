package com.example.codetest.brute.c6064;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_6064_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();

        for (int i=0; i < c; i++){
            String[] str = br.readLine().split(" ");
            int m = Integer.parseInt(str[0]);
            int n = Integer.parseInt(str[1]);
            int x = Integer.parseInt(str[2]);
            int y = Integer.parseInt(str[3]);

            int max = m * n / gcd(m, n);

            int result = -1;
            for (int j=0; j < max; j++){
                boolean a = ((j-x) % m == 0);
                boolean b = ((j-y) % n == 0);
                if(a&&b) {
                    result = j;
                    break;
                }
            }
            sb.append(result).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    private static int gcd(int m, int n) {
        return (n==0)? m : gcd(n,m % n);
    }
}

