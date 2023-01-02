package com.example.codetest.simulation.c15662;
// https://moonsbeen.tistory.com/282

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_15662_1 {
    static int N, K, Cnt = 0;
    static int[][] gear;
    static class Command {
        int idx, dir;
        public Command(int idx, int dir) {
            this.idx = idx;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                                new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        gear = new int[N][8];
        for(int i = 0; i < N; i++) {
            String[] str = (br.readLine()).split("");
            for(int j = 0; j < 8; j++) {
                gear[i][j] = Integer.parseInt(str[j]);
            }
        }

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            exec(idx-1, dir);
        }

        for(int i = 0; i < N; i++) Cnt += gear[i][0];
        System.out.println(Cnt);
    }

    public static void exec(int idx, int dir) {
        Queue<Command> queue = new LinkedList<>();
        queue.add(new Command(idx, dir));
        int rightDir = dir, leftDir = dir;

        for (int i = idx; i<N-1; i++){
            if (gear[i][2] != gear[i+1][6]){
                rightDir *= -1;
                queue.add(new Command(i+1, rightDir));
            }else {
                break;
            }
        }

        for (int i = idx; i>0; i--){
            if (gear[i-1][2] != gear[i][6]){
                leftDir *= -1;
                queue.add(new Command(i-1, leftDir));
            }else{
                break;
            }
        }

        while (!queue.isEmpty()) {
            Command now = queue.poll();
            turnGear(now.idx,now.dir);
        }
    }

    public static void turnGear(int idx, int dir) {
        if(dir == 1){
            int temp = gear[idx][7];
            for (int i = 7; i > 0; i--)
                gear[idx][i] = gear[idx][i-1];
            gear[idx][0] = temp;
        }else{
            int temp = gear[idx][0];
            for (int i = 0; i<7; i++)
                gear[idx][i] = gear[idx][i+1];
            gear[idx][7] = temp;
        }
    }
}

