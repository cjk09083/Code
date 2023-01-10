# 2022 01 10.

# https://www.acmicpc.net/problem/1929

'''
- 만약 n보다 작은 어떤 수 m이 m = ab라면 a와 b중 적어도 하나는 sqrt(n) 이하이다.
- n보다 작은 합성수 m은 sqrt(n)보다 작은 수의 배수만 체크해도 전부 지워지므로 , sqrt(n)하의 수의 배수만 지우면 된다.
'''

if __name__ == "__main__": 
    start, end = map(int,input().split())

    fList = [0] * (end+1)
    fList[1] = 1

    for i in range(2, end+1):
        if fList[i]==1:
            continue

        if start  <= i <= end:
            print(i)
        for j in range(2, (end//i)+1):
            fList[i*j] = 1

