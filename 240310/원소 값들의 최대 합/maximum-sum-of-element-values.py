import sys
n, m = map(int, sys.stdin.readline().split())
nums = list(map(int, sys.stdin.readline().split()))

def rec(idx, cnt):
    if cnt == 1:
        return nums[idx]
    return nums[idx] + rec(nums[idx] - 1, cnt - 1)

results = [rec(i, m) for i in range(n)]
print(max(results))
# print(results)