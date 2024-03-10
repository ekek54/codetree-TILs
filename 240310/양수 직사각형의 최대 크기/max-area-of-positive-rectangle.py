import sys
n, m = map(int, sys.stdin.readline().split())
board = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
answer = 0

def area(lt, rb):
    l, t = lt
    r, b = rb
    return ((r - l) + 1) * ((b - t) + 1)

for i in range(n):
    for j in range(m):
        if board[i][j] < 0: continue
        for k in range(i, n):
            for l in range(j, m):
                answer = max(answer, area((i, j), (k, l)))
                if board[k][l] < 0:
                    break
print(answer if answer > 0 else -1)