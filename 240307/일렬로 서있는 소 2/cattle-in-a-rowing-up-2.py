import sys

n = int(sys.stdin.readline())
A = list(map(int, sys.stdin.readline().split()))
answer = 0

for i in range(n - 2):
    for j in range(i + 1, n - 1):
        for k in range(j + 1, n):
            if A[i] <= A[j] <= A[k]:
                answer += 1

print(answer)