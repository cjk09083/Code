# 2022 01 20.

# https://www.acmicpc.net/problem/9095

'''
- DP를 사용해 미리 답을 구해놓고 출력 
- 36ms
'''
import sys
input = sys.stdin.readline

if __name__ == "__main__": 
    t = int(input())
    MAX = 11
    c = [0] * MAX
    c[1] = 1
    c[2] = 2
    c[3] = 4

    for i in range(4, MAX):
        c[i] = c[i-1] + c[i-2] + c[i-3]

    for _ in range(t):
        n = int(input())
        print(c[n])