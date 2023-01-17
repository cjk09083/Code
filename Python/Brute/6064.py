# 2022 01 17.

# https://www.acmicpc.net/problem/6064

'''
- M, N의 주기를 이용해 조건이 만족하는 i 값을 찾는다.
- 1096ms
'''
import sys
input = sys.stdin.readline


def gcd(a, b):
    return gcd(b, a % b) if b != 0 else a

if __name__ == "__main__": 
    n = int(input())
    ans = []
    for _ in range(n):
        M, N, x, y = map(int,input().split())
        # 최소 공배수
        end = int(M * N / gcd(M, N))

        result = -1

        for i in range(x,end+1,M):
            if (i-y) % N == 0:
                result = i
                break
        ans.append(result)
        # print(result)
        
    print(*ans, sep = "\n")