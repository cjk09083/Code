# 2022 01 11.

# https://www.acmicpc.net/problem/2309

'''
- itertools.combinations 사용하여 리스트내의 조합 찾기
- 조합된 리스트의 합이 100이 되는순간 정렬된 요소 출력
'''

from itertools import combinations

import sys
input = sys.stdin.readline

def getHeight():
    height = []
    for _ in range(9):
        height.append(int(input()))
    return height


if __name__ == "__main__": 

    hList = getHeight()

    for cList in combinations(hList, 7):
        if sum(cList) == 100:
            for height in sorted(cList):
                print(height)

            break
