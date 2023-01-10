# 2022 01 11.

# https://www.acmicpc.net/problem/3085

'''
- [i][j] 좌표를 가진 2차원 리스트 생성 (len = n) 
- 인접한 두 값을 바꿔가며 (i+1 < n 혹은 j+1 < n 일때) 길이 체크
- 가장 큰 길이를 값으로 제출
- 1076ms
'''
import sys
input = sys.stdin.readline

def cal(b, n, c):
    cnt = c
    for i in range(n):
        width = 1
        height = 1
        for j in range(n-1):
            if b[i][j] == b[i][j+1]:
                width += 1 
                if width > cnt:
                    cnt = width
            else:
                width = 1

            if b[j][i] == b[j+1][i]:
                height += 1 
                if height > cnt:
                    cnt = height
            else:
                height = 1

    return cnt


if __name__ == "__main__": 
    n = int(input())

    board = [list(map(str, input().rstrip())) for _ in range(n)]

    cnt = 0

    for i in range(n):
        for j in range(n):
            if j + 1 < n and board[i][j] != board[i][j+1]:
                board[i][j], board[i][j+1] = board[i][j+1], board[i][j]
                cnt = cal(board, n, cnt)
                board[i][j], board[i][j+1] = board[i][j+1], board[i][j]

            if i + 1 < n and board[i][j] != board[i+1][j]:
                board[i][j], board[i+1][j] = board[i+1][j], board[i][j]
                cnt = cal(board, n, cnt)
                board[i][j], board[i+1][j] = board[i+1][j], board[i][j]
    print(cnt)

