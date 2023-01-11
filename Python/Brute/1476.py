# 2022 01 12.

# https://www.acmicpc.net/problem/1476

'''
- 
- 40ms
'''

import sys
input = sys.stdin.readline


if __name__ == "__main__": 
    E, S, M = map(int,input().split())
    e, s, m = 0, 0, 0
    end = 1_000_000

    for i in range(end):
        if e == E and s == S and m == M:
            print(i)
            break

        e += 1
        if e > 15:
            e = 1
        s += 1
        if s > 28:
            s = 1
        m += 1
        if m > 19:
            m = 1
