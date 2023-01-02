package com.example.codetest.dynamic_pg.c1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

    /*
    https://st-lab.tistory.com/133
    N으로 각각 2와 3으로 나누면 depth 는 +1에 각 연산의 나머지 값을 더해준 것이 된다.
    나머지 값은 빼기 1했을 때의 depth 값과 같기 때문
    */

public class Main_1463_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(sol(N, 0));
    }

    static int sol(int n, int depth) {
        if (n < 2) return depth;
        return Math.min(
                sol(n / 2, depth + 1 + (n % 2)),
                sol(n / 3, depth + 1 + (n % 3))
            );
    }
}
