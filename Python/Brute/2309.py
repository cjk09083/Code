# 2022 01 10.

# https://www.acmicpc.net/problem/2309

'''
- 먼저 주어진 범위내의 소수를 모두 구한다.
- a를 2부터 1씩 증가시키며 a가 소수인지 확인한다.
- a가 소수라면 b = n-a가 소수인지 확인한다.
- a, b가 소수라면 결과를 출력한다.
- input = sys.stdin.readline  <== 여러줄 입력받을때 시간단축에 필요
'''

import sys

def getPrime(end):
    fList = [0] * (end+1)
    fList[1] = 1
    prime = []
    for i in range(2, end+1):
        if fList[i]==1:
            continue

        prime.append(i)
        for j in range(2, (end//i)+1):
            fList[i*j] = 1
    return prime, fList

if __name__ == "__main__": 
    input = sys.stdin.readline

    prime, fList = getPrime(1000000)

    while True:
        n = int(input())
        if n == 0:
            break
        
        for a in prime:
            b = n - a
            if fList[b] == 0:
                print(f'{n} = {a} + {b}')
                break
