# 2022 01 20.

# https://www.acmicpc.net/problem/9095

'''
- DFS를 사용해 전개 
- 48ms
'''
import sys
input = sys.stdin.readline

def dfs(depth, val, left):
    global ans
    if left < 0:
        return
    elif left == 0:
        print(f'd: {depth}, v: {val}, l: {left} COMP')
        ans += 1
        return
    elif depth > n:
        return
    else:
        
        for i in range(1, 4):
            new_val = val.copy()
            new_val.append(i)
            # print(f'd: {depth}, v: {new_val}, l: {left}, i:{i}')
            dfs(depth+1, new_val, left-i)

    return

if __name__ == "__main__": 
    t = int(input())
    result = []

    for _ in range(t):
        n = int(input())
        ans = 0
        for i in range(1, 4):
            val = [i]
            depth = 0
            left = n
            # print(f'd: {depth}, v: {val}, l: {left}, i:{i}')
            dfs(depth+1, val, left-i)
        result.append(ans)

    print(*result, sep = "\n")