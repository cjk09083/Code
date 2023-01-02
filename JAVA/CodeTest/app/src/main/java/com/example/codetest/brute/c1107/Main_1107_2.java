package com.example.codetest.brute.c1107;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1107_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] numArr = br.readLine().toCharArray();
        int err = Integer.parseInt(br.readLine());
        String[] errArr = {};
        if(err!=0)  errArr = br.readLine().split(" ");
        boolean[] stateArr = {true,true,true,true,true,true,true,true,true,true};

        for (int i=0; i < err; i++){
            stateArr[Integer.parseInt(errArr[i])] = false;
        }

        int num = Integer.parseInt(String.copyValueOf(numArr));
        int result = Math.abs(num-100);

        if(err!=10){
            result = getNum(num, stateArr);
        }
        System.out.println(result);
        br.close();
    }

    private static int getNum(int num, boolean[] stateArr) {
        int max = 999999;
        int closestNum = Math.abs(num-100);

        for (int i = 0; i < max; i++) {
            String str = String.valueOf(i);
            int len = str.length();
            boolean isBreak = false;

            for (int j = 0; j < len; j++) {
                if (!stateArr[str.charAt(j) - '0']) { //고장난 버튼을 눌러야 하면 (int 형변환 : -'0'(48))
                    isBreak = true;
                    break; //더 이상 탐색하지 않고 빠져나온다.
                }
            }
            if (!isBreak) { //i를 누를때 고장난 버튼을 누르지 않는다면
                int min = Math.abs(num - i) + len; //i를 누른 후(len) target까지 이동하는 횟수(target - i)
                closestNum = Math.min(min, closestNum);
            }
        }
        return closestNum;
    }

}

