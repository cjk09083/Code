# 2022 01 11.

# https://www.acmicpc.net/problem/2309

'''
- 2가지씩 제거하며 합이 100이 되는 순간을 체크
- print(*result, sep = "\n")  <== 구분자 사용
'''

import sys
input = sys.stdin.readline

def getHeight():
    height = []
    for _ in range(9):
        height.append(int(input()))
    return height

def getSolve(hList):
    tmp = sum(hList) 
    result = hList.copy()

    stop = False
    for i in range(9):
        if stop:
            break
        for j in range(i+1,9):
            if tmp - hList[i] - hList[j] == 100:
                result.remove(hList[i])
                result.remove(hList[j])
                stop = True
                break

    return sorted(result)

if __name__ == "__main__": 

    hList = getHeight()

    result = getSolve(hList)

    print(*result, sep = "\n")
