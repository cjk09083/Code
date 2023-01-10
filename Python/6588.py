# 2022 01 10.

# https://www.acmicpc.net/problem/6588

'''
- 먼저 주어진 범위내의 소수를 모두 구한다.
- a를 2부터 1씩 증가시키며 a가 소수인지 확인한다.
- a가 소수라면 b = n-a가 소수인지 확인한다.
- a, b가 소수라면 결과를 출력한다.
'''

if __name__ == "__main__": 
    end = 1000000

    fList = [0] * (end+1)
    fList[1] = 1

    for i in range(2, end+1):
        if fList[i]==1:
            continue

        for j in range(2, (end//i)+1):
            fList[i*j] = 1
    
    while True:
        n = int(input())
        if n == 0:
            break
        
        for a in range(0, end+1):
            if fList[a]==1:
                continue

            b = n - a
            if fList[b] == 0:
                print(f'{n} = {a} + {b}')
                break
