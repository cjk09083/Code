# 2022 01 05
# https://www.acmicpc.net/problem/1037

def main(inputList):
    ans = min(inputList) * max(inputList)
    print(ans)
    return


if __name__ == "__main__":
    num = int(input())
    inputList = list(map(int, input().split()))
    main(inputList)
