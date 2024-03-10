import sys
X, Y = map(int, sys.stdin.readline().split())
answer = 0
for i in range(X, Y + 1):
    num_str = str(i)
    reversed_num_str = "".join(reversed(list(num_str)))
    # print(num_str)
    # print(reversed_num_str)
    if num_str == reversed_num_str:
        answer += 1
print(answer)