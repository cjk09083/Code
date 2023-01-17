# 2022 01 17.

# https://www.acmicpc.net/problem/6064

'''
- M, N의 주기를 이용해 조건이 만족하는 i 값을 찾는다.
- pow(a, b, c) : a의 b승을 c로 나눈 나머지
- 40ms
'''

import math,sys
input = sys.stdin.readline


if __name__ == "__main__": 
    n = int(input())
    
    for _ in range(n):
        m,n,x,y=map(int,input().split())
        g = math.gcd(m,n)   # 최대 공약수
        if(x-y)%g:
            print(-1)
        else:
            a = pow(m//g,-1,n//g)       
            b = (m*n//g)                # LCM (최소공배수)
            c = m * a * (y-x)
            print((c//g + x-1) % b +1)
