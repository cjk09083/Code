import sys
input=sys.stdin.readline

def dfs(x, y, depth, current_sum):
    global max_sum

    if depth == 4:
        max_sum = max(max_sum, current_sum)
        return

    for dx, dy in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
        nx, ny = x + dx, y + dy
        if 0 <= nx < N and 0 <= ny < M and not visited[nx][ny]:
            visited[nx][ny] = True
            dfs(nx, ny, depth + 1, current_sum + board[nx][ny])
            visited[nx][ny] = False

def exception_shape(x, y):
    global max_sum

    shapes = [
        [(1, 0), (2, 0), (1, 1)],  # ㅗ
        [(1, 0), (2, 0), (1, -1)], # ㅜ
        [(0, 1), (0, 2), (1, 1)],  # ㅏ
        [(0, 1), (0, 2), (-1, 1)]  # ㅓ
    ]

    for shape in shapes:
        current_sum = board[x][y]
        is_valid = True

        for dx, dy in shape:
            nx, ny = x + dx, y + dy
            if 0 <= nx < N and 0 <= ny < M:
                current_sum += board[nx][ny]
            else:
                is_valid = False
                break

        if is_valid:
            max_sum = max(max_sum, current_sum)

if __name__ == "__main__": 
    N, M = map(int, input().split())
    board = [list(map(int, input().split())) for _ in range(N)]

    max_sum = 0
    visited = [[False for _ in range(M)] for _ in range(N)]

    for i in range(N):
        for j in range(M):
            visited[i][j] = True
            dfs(i, j, 1, board[i][j])
            visited[i][j] = False
            exception_shape(i, j)

    print(max_sum)
