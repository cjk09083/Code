package com.example.codetest.math.c3475;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_4375_1 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(System.in));
            String str = br.readLine();
            int n = Integer.parseInt(str);

            long value = 1;
            while(true){
                System.out.println(value);
                if(value % n == 0 )break;
                value = value * 10 + 1;
            }

            int len = (int)( Math.log10(value)+1 );
            System.out.println(len);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

