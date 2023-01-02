package com.example.codetest.simulation.c15685;
// https://velog.io/@hammii/%EB%B0%B1%EC%A4%80-15685-%EB%93%9C%EB%9E%98%EA%B3%A4-%EC%BB%A4%EB%B8%8C-java
/*
* 알고리즘
1. 방향을 d_list에 추가한다.
2. d_list에 있는 방향들을 마지막부터 뽑으면서 반시계 방향으로 한번 돌린 것을 다시 d_list에 추가한다.
3. d_list에 있는 방향들을 따라서 map[y][x]를 true로 설정한다.
4. map에서 네 점이 true 이면 카운트한다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15685_1 {
    static boolean[][] map = new boolean[101][101];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            dragonCurve(x, y, d, g);
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1]) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
        br.close();
    }

    public static void dragonCurve(int x, int y, int d, int g) {
        List<Integer> dList = new ArrayList<>();
        dList.add(d);

        for (int i = 1; i <= g; i++) {
            for (int j = dList.size() - 1; j >= 0; j--) {
                dList.add((dList.get(j) + 1) % 4);
            }
        }

        map[y][x] = true;
        for (Integer dir : dList) {
            x += dx[dir];
            y += dy[dir];
            map[y][x] = true;
        }
    }
}

