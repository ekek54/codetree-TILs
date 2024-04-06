import sys
from math import inf

n = int(sys.stdin.readline())
board = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
stack = []
visit = [False for _ in range(n)]
global answer
answer = -inf

def dfs(cnt):
    global answer
    if cnt == n:
        min_val = inf
        for i in range(n):
            min_val = min(min_val, board[i][stack[i]])
        answer = max(answer, min_val)
        return
    
    for i in range(n):
        if visit[i]: continue
        stack.append(i)
        visit[i] = True
        dfs(cnt + 1)
        visit[i] = False
        stack.pop()

dfs(0)
print(answer)