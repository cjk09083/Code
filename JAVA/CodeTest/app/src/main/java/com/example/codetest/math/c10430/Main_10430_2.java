package com.example.codetest.math.c10430;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10430_2 {
    public static void main(String[] args) {
        System.out.println("숫자를 입력해 주세요");

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String[] str = br.readLine().split(" ");
            int A = Integer.parseInt(str[0]);
            int B = Integer.parseInt(str[1]);
            int C = Integer.parseInt(str[2]);

            System.out.println( (A+B)%C );
            System.out.println( (A%C + B%C)%C );
            System.out.println( (A*B)%C );
            System.out.println( (A%C * B%C)%C );
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

