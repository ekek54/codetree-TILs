import sys

n = int(sys.stdin.readline())

def recursion(n):
    if n == 0:
        return 1
    return 3 * recursion(n - 1)

print(recursion(n))