import sys
from collections import deque
N = int(sys.stdin.readline())
board = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
dp = [[0 for j in range(N)] for i in range(N)]
dp[0][N - 1] = board[0][N - 1]
for i in range(N):
    for j in reversed(range(N)):
        if i == 0 and j == N - 1: continue
        candid = []
        if j + 1 < N:
            candid.append(dp[i][j + 1] + board[i][j])
        if i - 1 >= 0:
            candid.append(dp[i - 1][j] + board[i][j])
        dp[i][j] = min(candid)
print(min(dp[-1]))