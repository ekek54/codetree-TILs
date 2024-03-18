import sys

n = int(sys.stdin.readline())
meets = []
for _ in range(n):
    s, e = map(int, sys.stdin.readline().split())
    meets.append((s, e))
meets.sort(key = lambda x: (x[1],x[0]))
cnt = 0
cur_t = 0
for meet in meets:
    s, e = meet
    if cur_t <= s:
        cnt += 1
        cur_t = e
print(n - cnt)