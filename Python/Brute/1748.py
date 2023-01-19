# 2022 01 19.

# https://www.acmicpc.net/problem/1748

'''
- N의 자리수마다 개수를 구해 개수 * 길이를 더해간다.
if N is 120:
    '120' 길이 : 3
    1 자리수 9개 = 9
    2 자리수 90개 = 180
    3 자리수 21개 = 63
    ans = 252
- 40ms
'''
import sys
input = sys.stdin.readline


if __name__ == "__main__": 
    n = int(input())
    s = str(n)
    ans = 0

    for i in range(len(s)):
        j = i + 1
        if len(s) > j:
            cnt = (10**j) - (10**i) 
        else:
            cnt = n - (10**i) + 1

        add = cnt * j
        # print(f'{j} 자리수 {cnt}개 = {add}')
        ans += add

    print(ans)