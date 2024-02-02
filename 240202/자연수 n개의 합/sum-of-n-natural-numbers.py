import sys
s = int(sys.stdin.readline())
l = 0
r = 10 ** 10

def sum_from_one_to(n):
    return n * (n + 1) // 2

while l <= r:
    mid = (l + r) // 2
    if sum_from_one_to(mid) <= s:
        l = mid + 1
    else:
        r = mid - 1
print(r)