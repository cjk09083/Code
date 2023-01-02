package com.example.codetest.math.c2609;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2609_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);

        System.out.println(gcd(a,b));
        System.out.println(lcm(a,b));

        br.close();
    }

    //최대공약수
    public static int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
    //최소공배수
    public static int lcm(int a, int b) {
        //a * b = gcd(a,b) * lcm(a,b)
        return a * b / gcd(a, b);
    }
}

