import sys
n = int(sys.stdin.readline())
alphas = list(sys.stdin.readline().split())
cur_ord = ord('A')
cnt = 0
for i in range(n):
    cur_alpha = chr(cur_ord + i)
    # print(alphas.index(cur_alpha))
    cnt += alphas.index(cur_alpha)
    alphas.remove(cur_alpha)
print(cnt)