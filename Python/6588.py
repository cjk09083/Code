# 2022 01 10.

# https://www.acmicpc.net/problem/6588

'''

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

