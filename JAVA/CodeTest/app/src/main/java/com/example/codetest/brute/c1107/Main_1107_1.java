package com.example.codetest.brute.c1107;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1107_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         (1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19)
        char[] numArr = br.readLine().toCharArray();
        int err = Integer.parseInt(br.readLine());
        String[] errArr = {};
        if(err!=0)  errArr = br.readLine().split(" ");
        boolean[] stateArr = {true,true,true,true,true,true,true,true,true,true};

        for (int i=0; i < err; i++){
            stateArr[Integer.parseInt(errArr[i])] = false;
        }

        int result = 0;

        int len = numArr.length;
        int num = Integer.parseInt(String.copyValueOf(numArr));
        int dirGap = Math.abs(num-100);

//        System.out.println("목표: "+num +", len: "+len);
//        System.out.println("고장난 키: "+err+" = "+ Arrays.toString(errArr));
//        System.out.println("100과의 거리 : "+dirGap);

        if(err==10){
            result = dirGap;
        }else {
            int closestNum;
            closestNum = getNum(num, stateArr);

//            System.out.println("closestNum : "+ closestNum+", between: "+Math.abs(closestNum-num)+", len: "+len);
            result = Math.abs(closestNum-num)+len;
            if(dirGap < result) result = dirGap;
        }
        System.out.println(result);
        br.close();
    }
    private static int getNum(int num, boolean[] stateArr) {

        int max = 999999;
        int gap = max;
        int closestNum = 0;
        for (int i = 0; i < max; i++) {
            char[] numStr = String.valueOf(i).toCharArray();

            boolean chk = true;
            for (char c : numStr) {
//                System.out.println("i : "+ i+", j: "+j);

                int k = Character.getNumericValue(c);
//                System.out.println("k : "+ k+", state: "+stateArr[k]);

                if (!stateArr[k]) {
                    chk = false;
                    break;
                }
            }

            if (chk) {
//                System.out.println("gap : "+ gap+", before: "+Math.abs(num - i));
                if(Math.abs(num - i) < gap) {
                    gap = Math.abs(num - i);
                    closestNum = i;
                }else{
                    break;
                }
            }
        }

        return closestNum;
    }

}

