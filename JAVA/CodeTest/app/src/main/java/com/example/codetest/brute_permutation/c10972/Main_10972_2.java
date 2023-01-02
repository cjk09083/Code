package com.example.codetest.brute_permutation.c10972;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_10972_2 {
    // https://pangtrue.tistory.com/327

    static int N;
    static int[] numArr;
    static boolean debug = true;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        if(sol(numArr.length - 1)){
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < N; j++) sb.append(numArr[j]).append(" ");
            System.out.println(sb);
        }else{
            System.out.println("-1");
        }
    }

/*
7
1 4 6 5 7 3 2
*/
    private static boolean sol(int lastIdx) {
        int i = lastIdx;                                            // 배열 오른쪽부터 탐색 시작
        while (i > 0 && numArr[i - 1] >= numArr[i]) {
            debug(i,0, 1);
            i--;
        }        // 스왑할 순서가 있나 탐색
        if (i <= 0) return false;                                   // 맨 왼쪽까지 없으면 false
        debug(i, 0, 1);

        int j = lastIdx;                                            // 배열 오른쪽부터
        while (numArr[j] <= numArr[i - 1]) {                        // 그 다음으로 큰 숫자 탐색
            debug(i, j, 2);
            j--;
        }
        debug(i, j, 2);
        swap(i - 1, j);                                             // 두 숫자를 스왑

        j = lastIdx;                                                // 스왑한 원소 위치 부터
        while (i < j) {                                             // 한칸씩 이동하며
            debug(i, j, 3);
            swap(i, j);                                             // 오른쪽이 더 크면 왼쪽과 스왑
            i++;                                                    // 최종적으로 큰 숫자가 왼쪽으로
            j--;
        }
        return true;
    }

    private static void swap(int idx1, int idx2) {
        int temp = numArr[idx1];
        numArr[idx1] = numArr[idx2];
        numArr[idx2] = temp;
        debug(idx2, idx1, 4);
    }


    private static void debug(int i, int j, int type) {
        if (debug) {
            if(type == 0) System.out.println("numArr: " + Arrays.toString(numArr));
            else if(type == 1) System.out.println("i: " + i + ", " + numArr[i - 1] + " vs " + numArr[i]);
            else if(type == 2) System.out.println("i-1: "+(i-1)+", j: "+j+", "+numArr[i-1]+" vs "+numArr[j]);
            else if(type == 3) System.out.println("Sort i: "+i+", j: "+j+", "+numArr[i]+" vs "+numArr[j]);
            else if(type == 4) System.out.println("Swap: "+numArr[i]+"["+j+"] <-> "+ numArr[j]+"["+i+"] "
                    +"=> " + Arrays.toString(numArr));

        }
    }

}
