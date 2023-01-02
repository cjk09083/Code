package com.example.codetest.simulation.c14499;
// https://hunucho.tistory.com/entry/Baekjoon-16927-배열-돌리기-2-JAVA [훈발자:티스토리]

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14499_1 {
    static int N, M, K;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    static Dice dice;
    static class Dice {
        int posX, posY;
        int up,down,left,right,top,bottom;

        public Dice(int x, int y, int up, int down, int left, int right, int top, int bottom) {
            this.posX = x;
            this.posY = y;
            this.up = up;
            this.down = down;
            this.left = left;
            this.right = right;
            this.top = top;
            this.bottom = bottom;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int initX = Integer.parseInt(st.nextToken());
        int initY = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dice = new Dice(initX,initY,0,0,0,0,0,0);

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) rotate(Integer.parseInt(st.nextToken()));

        System.out.println(sb);
    }

    static void rotate(int cmd) {
        // 0.bottom, 1.left, 2.right, 3.up, 4.down, 5.top
        int[] tempDice = {dice.bottom, dice.left, dice.right, dice.up, dice.down, dice.top};

        switch (cmd){
            case 1:
                if(dice.posX+1>=M) return;
                dice.posX += 1;
                dice.bottom = tempDice[2];
                dice.top = tempDice[1];
                dice.left = tempDice[0];
                dice.right = tempDice[5];
                break;
            case 2:
                if(dice.posX-1 <0) return;
                dice.posX -= 1;
                dice.bottom = tempDice[1];
                dice.top = tempDice[2];
                dice.left = tempDice[5];
                dice.right = tempDice[0];
                break;
            case 3:
                if(dice.posY-1 <0) return;
                dice.posY -= 1;
                dice.bottom = tempDice[3];
                dice.top = tempDice[4];
                dice.up = tempDice[5];
                dice.down = tempDice[0];
                break;
            case 4:
                if(dice.posY+1 >=N) return;
                dice.posY += 1;
                dice.bottom = tempDice[4];
                dice.top = tempDice[3];
                dice.up = tempDice[0];
                dice.down = tempDice[5];
                break;
        }

        if (arr[dice.posY][dice.posX]==0) arr[dice.posY][dice.posX] = dice.bottom;
        else {
            dice.bottom = arr[dice.posY][dice.posX];
            arr[dice.posY][dice.posX] = 0;
        }

        sb.append(dice.top).append("\n");
    }

}

