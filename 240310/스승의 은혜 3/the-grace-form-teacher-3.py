import sys
N, B = map(int, sys.stdin.readline().split())
costs = [[0, 0] for _ in range(N)]
for i in range(N):
    p, s = map(int, sys.stdin.readline().split())
    costs[i][0] = p
    costs[i][1] = s
costs.sort(key = lambda x:sum(x))
answer = 0
for i in range(N):
    budget = B
    cnt = 0
    sale_cost = costs[i][0] // 2 + costs[i][1]
    if budget >= sale_cost:
        cnt += 1
        budget -= sale_cost
    for j in range(N):
        if j == i: continue
        cur_cost = sum(costs[j])
        if budget - cur_cost > 0:
            cnt += 1
            budget -= cur_cost
        else: break
    answer = max(answer, cnt)

print(answer)
# print(costs)