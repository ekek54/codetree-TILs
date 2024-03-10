import sys
N = int(sys.stdin.readline())
S = sys.stdin.readline().rstrip()
answer = N

for i in range(N):
    flag = False
    for j in range(N - i):
        word = S[j: j + i + 1]
        count = 0
        for k in range(N - i):
            cmp_word = S[k: k + i + 1]
            if word == cmp_word:
                count += 1
        # print(word)
        # print(count)
        if count > 1:
            flag = True
    if not flag:
        answer = i + 1
        break
print(answer)