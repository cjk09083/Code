# 2022 01 11.

# https://www.acmicpc.net/problem/3085

'''
- [i][j] 좌표를 가진 2차원 리스트 생성 (len = n) 
- 인접한 두 값을 바꿔가며 (i+1 < n 혹은 j+1 < n 일때) 길이 체크
- 가장 큰 길이를 값으로 제출
- 바꾼 [i][j]에서 left,right,up,down 방향만 확인하도록 변경
- 60ms
'''

import sys
input = sys.stdin.readline


dx = [-1, 1, 0, 0]
dy = [0, 0, 1, -1]

def cal(x, y):
    width, height = 1,1
    for i in range(4):
        xx, yy = x+dx[i], y+dy[i]

        while 0 <= xx < n and 0 <= yy < n and board[x][y] == board[xx][yy]:
            if dy[i] == 0:
                width += 1
            else :
                height += 1
            xx += dx[i]
            yy += dy[i]

    return max(width, height)


if __name__ == "__main__": 
    n = int(input())
    board = [list(map(str, input().rstrip())) for _ in range(n)]
    # print(*board, sep = "\n")
    cnt = 0

    for i in range(n):
        for j in range(n):
            cnt = max(cnt, cal(i, j))
            if j + 1 < n and board[i][j] != board[i][j+1]:
                board[i][j], board[i][j+1] = board[i][j+1], board[i][j]
                cnt = max(cnt, cal(i, j))
                cnt = max(cnt, cal(i, j+1))
                board[i][j], board[i][j+1] = board[i][j+1], board[i][j]

            if i + 1 < n and board[i][j] != board[i+1][j]:
                board[i][j], board[i+1][j] = board[i+1][j], board[i][j]
                cnt = max(cnt, cal(i, j))
                cnt = max(cnt, cal(i+1, j))
                board[i][j], board[i+1][j] = board[i+1][j], board[i][j]
    print(cnt)
