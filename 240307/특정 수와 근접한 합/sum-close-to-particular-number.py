import sys
from math import inf
N, S = map(int, sys.stdin.readline().split())
nums = list(map(int, sys.stdin.readline().split()))
all_sum = sum(nums)
best_gap = inf
answer = 0
for i in range(N - 1):
    for j in range(i + 1, N):
        partial_sum = all_sum - nums[i] - nums[j]
        gap = abs(S - partial_sum)
        best_gap = min(best_gap, gap)

print(best_gap)