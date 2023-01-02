package com.example.codetest.math.c17427;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_17427_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long result = 0;

        for (int i = 1; i <= n; i++){
            // 정수끼리의 나눗셈은 정수로 나온다. 분모/분자중 하나라도 실수이면 실수 return;
            System.out.println(i+": "+n+" / "+i+" = "+(n/i)+"개");
            result += (long) i * (n/i);
        }

        System.out.println(result);
        br.close();
    }
}

/*
n이하 i를 약수로 갖는 수의 개수 = n 이하의 i의 배수들 이라고 바꿔풀면, n이하 i의 배수들은 n/i가 된다.

ex) 100이하 11의 배수들 -> 11,22,33,44,55,66,77,88,99 총 9개 = 100/11

나머지도 동일하다.
*/
