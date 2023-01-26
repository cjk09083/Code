# 2022 01 26.

# https://www.acmicpc.net/problem/15650

'''
- DFS를 사용해 전개
- 최근[-1] 원소보다 큰 원소만 저장 
- 40ms
'''
import sys
input = sys.stdin.readline

def dfs(depth, val):
    global visit
    if depth ==  m:
        print(*val, sep = " ")
        return
    else:
        for i in range(1,n+1):
            if visit[i] == 0 and i > val[-1]:
                new_val = val.copy()
                new_val.append(i)
                visit[i] = 1
                dfs(depth+1, new_val)
                visit[i] = 0

    return

if __name__ == "__main__": 
    n, m = map(int, input().split())
    result = []
    arr = list(range(1,n+1))
    visit = [0] * (n+1)
    # print(arr)
    for i in range(1,n+1):
        val = [i]
        depth = 0
        left = n
        visit[i] = 1
        dfs(depth+1, val)
        visit[i] = 0