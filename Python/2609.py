# 2022 01 06.

# https://www.acmicpc.net/problem/2609

'''
최대공약수 gcd : return b != 0 ? gcd(b, a % b) : a;
최소공배수 lcm : return a * b / gcd(a, b);
a * b = gcd(a,b) * lcm(a,b)

삼항 연산자: [true_value] if [condition] else [false_value]
'''

def gcd(a, b):
    return gcd(b, a % b) if b != 0 else a

if __name__ == "__main__": 
    a, b = map(int,input().split())
    g = gcd(a, b)
    l = int((a*b) / g)
    print(g)
    print(l)