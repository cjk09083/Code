# 2022 01 05
# https://www.acmicpc.net/problem/4375

inputList = []

def main(inputList):
    for n in inputList:
        ans = '1'
        while True:
            if int(ans) % n == 0:
                print(len(ans))
                break
            ans += '1'


if __name__ == "__main__":
    while True:
        try:
            inputList.append(int(input()))
        except:
            break
    main(inputList)
