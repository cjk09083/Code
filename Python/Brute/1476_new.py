# 2022 01 12.

# https://www.acmicpc.net/problem/1476

'''
- E, S, M의 주기를 이용해 조건이 만족하는 i 값을 찾는다.
- 36ms
'''

import sys
input = sys.stdin.readline


if __name__ == "__main__": 
    E, S, M = map(int,input().split())
    end = 1_000_000

    for i in range(1,end):
        if (i-E)%15 == 0 and (i-S)%28 ==0 and (i-M)%19 == 0:
            print(i)
            break