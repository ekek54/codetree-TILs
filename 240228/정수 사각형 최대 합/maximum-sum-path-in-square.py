import sys
N = int(sys.stdin.readline())
board = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
dp = [[0 for j in range(N)] for i in range(N)]
dp[0][0] = board[0][0]
for i in range(N):
    for j in range(N):
        if i == 0 and j == 0: continue
        candid = []
        if i - 1 >= 0:
            candid.append(dp[i - 1][j] + board[i][j])
        if j - 1 >= 0:
            candid.append(dp[i][j - 1] + board[i][j])
        dp[i][j] = max(candid)
print(max(dp[-1]))