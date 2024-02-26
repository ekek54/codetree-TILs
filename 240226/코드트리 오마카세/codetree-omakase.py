import sys

L, Q = map(int, sys.stdin.readline().split())
#name: set((t, x),...)
sushi_dict = {}
#name: t
guest_t = {}
#name: x
guest_x = {}
#name: n
guest_n = {}

def make_sushi(t, x, name):
    if name not in sushi_dict:
        sushi_dict[name] = set()
    sushi_dict[name].add((t, x))
    return

def guest_in(t, x, name, n):
    guest_t[name] = t
    guest_x[name] = x
    guest_n[name] = n

def eat(name, sushi, photo_t):
    sushi_t, sushi_x = sushi
    gap = (guest_x[name] - sushi_x) % L
    at_x_t = sushi_t + gap
    if at_x_t > photo_t:
        return False
    at_x_t += ((photo_t - at_x_t) // L) * L
    # print(sushi_t, photo_t, guest_x[name], gap)
    return guest_t[name] <= at_x_t
            


def photo(photo_t):
    done_guest = []
    for name in guest_t.keys():
        if name in sushi_dict:
            eaten = []
            for sushi in sushi_dict[name]:
                if eat(name, sushi, photo_t): 
                    eaten.append(sushi)
            
            guest_n[name] -= len(eaten)
            if guest_n[name] == 0:
                done_guest.append(name)
            for sushi in eaten:
                sushi_dict[name].remove(sushi)
    for name in done_guest:
        guest_t.pop(name)
    sushi_cnt = sum(map(len, sushi_dict.values()))
    guest_cnt = len(guest_t.keys())
    print(guest_cnt, sushi_cnt)
            
        
for _ in range(Q):
    cmds = sys.stdin.readline().split()
    q_type = int(cmds[0])
    if q_type == 100:
        t = int(cmds[1])
        x = int(cmds[2])
        name = cmds[3]
        make_sushi(t, x, name)
    elif  q_type == 200:
        t = int(cmds[1])
        x = int(cmds[2])
        name = cmds[3]
        n = int(cmds[4])
        guest_in(t, x, name, n)
    else:
        t = int(cmds[1])
        photo(t)