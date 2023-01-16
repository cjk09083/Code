# 2022 01 16.

# https://www.acmicpc.net/problem/14500

'''
- DFS를 사용해 탐색
- 172ms
'''
import sys
input=sys.stdin.readline

dx=[0,1,0,-1]
dy=[1,0,-1,0]

def dfs(x,y,depth,res):
    global answer
    # 종료조건1) 탐색을 계속 진행하여도 최댓값에 못 미치는 경우
    if answer >= res + MAX*(4-depth):
        return

    # 종료조건2) 블록 4개를 모두 활용한 경우
    if depth==4:
        answer = max(answer, res)
        return

    # 상하좌우 방향으로 블록 이어 붙여 나가기
    for i in range(4):
        nx=x+dx[i] # 새로운 x 좌표
        ny=y+dy[i] # 새로운 y 좌표
        # 새로운 좌표가 유효한 범위 내 있고 탐색이력이 없는 경우
        if 0 <= nx < m and 0 <= ny < n and visit[ny][nx]==0:
            # 2번째 블록 연결 후 'ㅏ','ㅓ','ㅗ','ㅜ' 만들기
            if depth==2:
                visit[ny][nx]=1
                dfs(x,y,depth+1,res+board[ny][nx])
                visit[ny][nx]=0
            visit[ny][nx]=1
            dfs(nx,ny,depth+1,res+board[ny][nx])
            visit[ny][nx]=0

if __name__ == "__main__": 
    n,m=map(int,input().split())
    board=[list(map(int,input().split())) for _ in range(n)]
    answer,MAX = 0,max(map(max,board))
    visit=[[0]*m for _ in range(n)]

    for i in range(n):
        for j in range(m):
            visit[i][j]=1
            dfs(j,i,1,board[i][j])
            visit[i][j]=0

    print(answer)
