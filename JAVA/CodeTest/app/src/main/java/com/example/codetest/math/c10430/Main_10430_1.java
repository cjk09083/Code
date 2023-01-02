package com.example.codetest.math.c10430;

import java.util.Scanner;
public class Main_10430_1 {
    public static void main(String[] args) {
        System.out.println("숫자를 입력해 주세요");

        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int B = in.nextInt();
        int C = in.nextInt();
        in.close();

        System.out.println( (A+B)%C );
        System.out.println( (A%C + B%C)%C );
        System.out.println( (A*B)%C );
        System.out.println( (A%C * B%C)%C );
    }
}

