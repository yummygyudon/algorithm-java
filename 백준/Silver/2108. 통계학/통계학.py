def merge_sort(ary) :
    def _merge_sort(ary, l, r) :
        if l < r :
            center = (l+r) //2
            _merge_sort(ary, l, center)
            _merge_sort(ary, center+1, r)
            p = j = 0
            i = k = l
            while i <= center :
                tmp[p] = ary[i]
                p += 1
                i += 1
            while i <= r and j < p :
                if tmp[j] <= ary[i] :
                    ary[k] = tmp[j]
                    j += 1
                else :
                    ary[k] = ary[i]
                    i += 1
                k += 1
            while j < p :
                ary[k] = tmp[j]
                k += 1
                j += 1
    n = len(ary)
    tmp = [None] * n
    _merge_sort(ary, 0, (n-1))
import sys
N = int(sys.stdin.readline())
ary = []
for _ in range(N):
    ary.append(int(sys.stdin.readline()))
merge_sort(ary)
print(round(sum(ary)/N))
print(ary[(N-1)//2])
from collections import Counter
Count = Counter(ary).most_common()
if len(Count) >= 2 :
    if Count[0][1] == Count[1][1] :
        print(Count[1][0])
    else :
        print(Count[0][0])
else:
    print(Count[0][0])
print(ary[-1] -ary[0])