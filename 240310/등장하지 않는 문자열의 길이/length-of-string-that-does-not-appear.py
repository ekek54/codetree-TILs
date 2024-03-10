import sys
N = int(sys.stdin.readline())
S = sys.stdin.readline().rstrip()
answer = N

for i in range(N):
    flag = False
    for j in range(N - i):
        word = S[j: j + i + 1]
        if S.count(word) != 1:
            flag = True
            break
        # print(word)
        # print(S.count(word))
    if not flag:
        answer = i + 1
        break
print(answer)