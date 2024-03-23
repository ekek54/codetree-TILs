import sys

n = int(sys.stdin.readline())
axis = {}
for _ in range(n):
    x, y = map(int, sys.stdin.readline().split())
    if x in axis and axis[x] > y:
        axis[x] = y
    elif x not in axis:
        axis[x] = y

print(sum(axis.values()))