package com.example.codetest.brute.c6064;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* https://1-7171771.tistory.com/38
ex M=5, N=7
1: <1,1> 6: <1,6> 11<1,4> 16<1,2> 21<1,7> 26<1,5> 31<1,3>
2: <2,2> 7: <2,7> 12<2,5> 17<2,3> 22<2,1> 27<2,6> 32<2,4>
3: <3,3> 8: <3,1> 13<3,6> 18<3,4> 23<3,2> 28<3,7> 33<3,5>
4: <4,4> 9: <4,2> 14<4,7> 19<4,5> 24<4,3> 29<4,1> 34<4,6>
5: <5,5> 10:<5,3> 15<5,1> 20<5,6> 25<5,4> 30<5,2> 35<5,7>
*/

public class Main_6064_2 {
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
            for (int j=x; j <= max;  j+= m){
                if((j - y) % n == 0) {
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

