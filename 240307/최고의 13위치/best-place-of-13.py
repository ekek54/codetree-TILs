import sys

N = int(sys.stdin.readline())
board = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
answer = 0

for i in range(N):
    for j in range(N - 2):
        answer = max(answer, sum(board[i][j: j + 3]))
print(answer)