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
    if answer >= res + MAX*(4-depth):
        return
    
    if depth==4:
        answer = max(answer, res)
        return

    for i in range(4):
        nx=x+dx[i]
        ny=y+dy[i]
        if 0 <= nx < m and 0 <= ny < n and visit[ny][nx]==0:
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
