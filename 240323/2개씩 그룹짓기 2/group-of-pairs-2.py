import sys
from math import inf

n = int(sys.stdin.readline())
nums = list(map(int, sys.stdin.readline().split()))
nums.sort()
answer = inf
for i in range(n):
    answer = min(answer, nums[i + n] - nums[i])
print(answer)