import sys
n, k = map(int, sys.stdin.readline().split())
era = [False for _ in range(n + 1)]
cnt = 0
done = False
answer = 0
for i in range(2, n):
    if era[i]: continue
    j = 0
    while 1:
        j += 1
        if i * j > n: break
        if era[i * j]: continue
        era[i * j] = True
        answer = i * j
        cnt += 1
        if cnt == k:
            done = True
            break
    if done: break

print(answer)