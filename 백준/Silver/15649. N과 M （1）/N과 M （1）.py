import sys
input = sys.stdin.readline

TARGET_NUM, POS_COUNT = map(int,input().split())

CHECK = [False]*TARGET_NUM
NUMS = [0]*POS_COUNT
def check(cnt) :
    if cnt == POS_COUNT :
        print(*NUMS)
        return

    for i in range(TARGET_NUM) :
        if not CHECK[i] :
            NUMS[cnt] = i+1
            CHECK[i] = True
            check(cnt+1)
            CHECK[i] = False
check(0)