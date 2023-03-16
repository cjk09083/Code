import sys

def dfs(x, y, cnt):
    global ans, total, visited

    if cnt == 4:
        ans = max(ans, total)
        return

    

    for dx, dy in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
        nx, ny = x + dx, y + dy
        if nx < 0 or nx >= n or ny < 0 or ny >= m or visited[nx][ny]:
            continue
            
        # T자 블록 고려
        if cnt == 2:
            visited[nx][ny] = True
            total += a[nx][ny]
            dfs(x, y, cnt + 1)
            total -= a[nx][ny]
            visited[nx][ny] = False
            
        visited[nx][ny] = True
        total += a[nx][ny]
        dfs(nx, ny, cnt + 1)
        total -= a[nx][ny]
        visited[nx][ny] = False

if __name__ == "__main__":
    n, m = map(int, sys.stdin.readline().split())
    a = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

    visited = [[False] * m for _ in range(n)]
    ans = 0

    for i in range(n):
        for j in range(m):
            visited[i][j] = True
            total = a[i][j]
            dfs(i, j, 1)
            visited[i][j] = False

    print(ans)