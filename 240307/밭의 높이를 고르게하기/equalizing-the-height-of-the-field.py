import sys
from math import inf
N, H, T = map(int, sys.stdin.readline().split())
costs = list(map(lambda x: abs(int(x) - H), sys.stdin.readline().split()))
answer = inf
for i in range(N - (T - 1)):
    answer = min(answer, sum(costs[i: i + T]))

print(answer)