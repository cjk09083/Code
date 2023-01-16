# 2022 01 16.

# https://www.acmicpc.net/problem/14500

'''
- 주어진 board에서 가장자리에 0배열 3칸씩 추가
- 3,3 부터 n+3, m+3까지 변경하며 왼쪽위에서 시작하는 모든 도형의 경우의수 계산
- 경우의 수 중 가장 큰 값을 출력
- 1380ms
'''
import sys
input=sys.stdin.readline

def getBox():
    board = []
    for _ in range(3):
        board.append([0]*(m+6))
    for _ in range(n):
        tmp = [0,0,0]
        tmp += list(map(int, input().split()))
        tmp += [0,0,0]
        board.append(tmp)
    for _ in range(3):
        board.append([0]*(m+6))

    return board

def sol(i,j):
    cnt = 0
    # 1 직선 (세로놓기)
    cnt = max(cnt, b[i][j] + b[i+1][j] + b[i+2][j] + b[i+3][j])
    # 2 직선 (가로놓기)
    cnt = max(cnt, b[i][j] + b[i][j+1] + b[i][j+2] + b[i][j+3])
    # 3 네모
    cnt = max(cnt, b[i][j] + b[i][j+1] + b[i+1][j+1] + b[i+1][j])
    # 4 ㄴ // 왼상단 시작 오른 하단 종료. (세로가 큰 ㄴ)
    cnt = max(cnt, b[i][j] + b[i+1][j] + b[i+2][j] + b[i+2][j+1])
    # 5 ㄴ // 오른 상단 시작 왼 하단 종료. (4 좌우 대칭)
    cnt = max(cnt, b[i][j+1] + b[i+1][j+1] + b[i+2][j+1] + b[i+2][j])
    # 6 ㄴ // 왼하단 시작 오른 상단 종료. (가로가 긴 ㄱ)
    cnt = max(cnt, b[i][j] + b[i][j+1] + b[i][j+2] + b[i+1][j+2])
    # 7 ㄴ // 왼하단 시작 오른 상단 종료. (6 대칭)
    cnt = max(cnt, b[i+1][j] + b[i][j] + b[i][j+1] + b[i][j+2])
    # 8 ㄴ // 왼상단 시작 오른 하단 종료. (세로가 긴 ㄱ)
    cnt = max(cnt, b[i][j] + b[i][j+1] + b[i+1][j+1] + b[i+2][j+1])
    # 9 ㄴ // 왼상단 시작 오른 하단 종료. (8 대칭)
    cnt = max(cnt, b[i][j+1] + b[i][j] + b[i+1][j] + b[i+2][j])
    # 10 ㄴ // 오른 상단 시작 왼 하단 종료 (가로가 긴 ㄴ)
    cnt = max(cnt, b[i][j] + b[i+1][j] + b[i+1][j+1] + b[i+1][j+2])
    # 11 ㄴ // 오른 상단 시작 왼 하단 종료 (10 대칭)
    cnt = max(cnt, b[i+1][j] + b[i+1][j+1] + b[i+1][j+2] + b[i][j+2])
    # 12 ㄴㄱ  // 왼 상단 시작 오른 하단 종료 (ㄴ 밑에 ㄱ)
    cnt = max(cnt, b[i][j] + b[i+1][j] + b[i+1][j+1] + b[i+2][j+1])
    # 13 ㄴㄱ  // 왼 하단 시작 오른 상단 종료 (ㄴ 밑에 ㄱ 좌우 반전)
    cnt = max(cnt, b[i][j+1] + b[i+1][j+1] + b[i+1][j] + b[i+2][j])
    # 14 ㄴㄱ  // 왼 상단 시작 오른 하단 종료 (ㄱ 우측에 ㄴ)
    cnt = max(cnt, b[i][j] + b[i][j+1] + b[i+1][j+1] + b[i+1][j+2])
    # 15 ㄴㄱ  // 오른 상단 시작 왼 하단 종료 (ㄱ 우측에 ㄴ 상하 반전)
    cnt = max(cnt, b[i+1][j] + b[i+1][j+1] + b[i][j+1] + b[i][j+2])
    # 16 ㅗ // ㅜ
    cnt = max(cnt, b[i][j] + b[i][j+1] + b[i+1][j+1] + b[i][j+2])
    # 17 ㅗ // ㅓ
    cnt = max(cnt, b[i][j+1] + b[i+1][j+1] + b[i+2][j+1] + b[i+1][j])
    # 18 ㅗ // ㅗ
    cnt = max(cnt, b[i+1][j] + b[i+1][j+1] + b[i][j+1] + b[i+1][j+2])
    # 19 ㅗ // ㅏ
    cnt = max(cnt, b[i][j] + b[i+1][j] + b[i+1][j+1] + b[i+2][j])

    return cnt

if __name__ == "__main__": 
    n, m = map(int,(input().split()))
    b = getBox()
    # print(*b, sep = "\n")
    result = 0

    for i in range(n):
        for j in range(m):
            result = max(result,sol(i+3,j+3))

    print(result)
