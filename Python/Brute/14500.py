# 2022 01 14.

# https://www.acmicpc.net/problem/14500

'''
- closestNum를 0부터 999999까지 올려가면서 가장 가까운 숫자를 찾는다.
- 708ms
'''
import sys
input = sys.stdin.readline


def isBtnOnly():
    btnOnly = True
    for i in str(t):
        if i in err:
            btnOnly = False
            break

    return btnOnly

def getNum():
    if isBtnOnly():
        return min(abs(t-100),len(str(t)))
    
    start = 0
    end = 1_000_000
    closestNum = abs(t - 100)

    for i in range(start, end):
        tmp = str(i)
        l = len(tmp)
        isBreak = False

        for j in range(l):
            if tmp[j] in err:
                isBreak = True
                break

        if not isBreak:
            c = abs(t - i) + l
            closestNum = min(c, closestNum)
            
    return closestNum

if __name__ == "__main__": 
    t = int(input()) 
    n = int(input())
    if t == 100:
        cnt = 0
    elif n == 0:
        cnt = min(abs(t-100),len(str(t)))
    elif n == 10:
        cnt = abs(t-100)
    else:
        err = list(map(str, input().split()))
        cnt = getNum()

    print(cnt)

    
