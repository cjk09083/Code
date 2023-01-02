package com.example.codetest.math.c1917;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1917_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] strArr = br.readLine().split(" ");
        int[] numArr = Arrays.stream(strArr).mapToInt(Integer::parseInt).toArray();
        int max =  Arrays.stream(numArr).max().getAsInt();
        int min =  Arrays.stream(numArr).min().getAsInt();

        System.out.println(max * min);
        br.close();
    }

    //에라토스테네스의 체

}

