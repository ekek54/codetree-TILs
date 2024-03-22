import sys
from math import inf

n = int(sys.stdin.readline())

nums = list(map(int, sys.stdin.readline().split()))
nums.sort()
answer = max(nums[-1] * nums[-2] * nums[-3], nums[0] * nums[1] * nums[-1])
print(answer)