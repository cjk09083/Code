# 2022 01 06.

# https://www.acmicpc.net/problem/17425

'''
DP로 모든 g(n)을 계산해두고 n값에 따라 순차적으로 출력
'''

def main():
    max = 1_000_000
    f = [1 for x in range(max+1)]
    g = [0 for x in range(max+1)]

    for n in range(2,max+1):
        for i in range(1,int(max/n)+1):
            f[n*i] += n

    for n in range(1,max+1):
        g[n] = g[n-1] + f[n]

    return g

if __name__ == "__main__":    
    g = main()
    num = int(input())
    ans = []
    for _ in range(num):
        n = int(input())
        ans.append(g[n])

    for result in ans:
        print(str(result))