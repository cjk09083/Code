# 2022 01 03
# https://www.acmicpc.net/problem/10430

A,B,C = map(int,input().split())

print((A+B)%C)
print(((A%C)+(B%C))%C)
print((A*B)%C)
print(((A%C)*(B%C))%C)