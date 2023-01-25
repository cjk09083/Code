# 2022 01 25.

# https://www.acmicpc.net/problem/15649

'''
- DFS를 사용해 전개 
- 192ms
'''
import sys
input = sys.stdin.readline

def dfs(depth, val, visit):
    if depth ==  m:
        print(*val, sep = " ")
        return
    else:
        new_visit = visit.copy()
        for i in range(1,n+1):
            if visit[i] == 0:
                new_val = val.copy()
                new_val.append(i)
                new_visit[i] = 1
                dfs(depth+1, new_val, new_visit)
                new_visit[i] = 0

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
        dfs(depth+1, val, visit)
        visit[i] = 0