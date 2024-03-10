import sys
N = int(sys.stdin.readline())
S = sys.stdin.readline().rstrip()
answer = 0

for i in range(N):
    word = S[: i + 1]
    if S.count(word) == 1:
        answer = len(word)
        break
print(answer)