# 2022 01 09.

# https://www.acmicpc.net/problem/1978

'''
- 만약 n보다 작은 어떤 수 m이 m = ab라면 a와 b중 적어도 하나는 sqrt(n) 이하이다.
- n보다 작은 합성수 m은 sqrt(n)보다 작은 수의 배수만 체크해도 전부 지워지므로 , sqrt(n)하의 수의 배수만 지우면 된다.
'''
import math

max = 1000
fList = [0 for x in range(max+1)]

if __name__ == "__main__": 
    num = int(input())
    iList = input().split()

    fList[1] = 1

    for i in range(2, int(math.sqrt(max))+1):
        for j in range(2, int(max/i)+1):
            fList[i*j] = 1

    result = 0
    for i in iList:
        if fList[int(i)] == 0:
            result += 1

    print(result)