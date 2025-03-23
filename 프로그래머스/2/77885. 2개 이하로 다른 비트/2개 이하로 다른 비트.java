class Solution {
    public long[] solution(long[] numbers) {
            long[] answer = new long[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                long x = numbers[i];
                if ((x & 1) == 0) {
                    answer[i] = x + 1;
                } else {
                    long lowBit = x & -x; // x에서 가장 낮은 겹치는 1 위치(가장 작은 변경) 
                    long next = x + lowBit; // x에서 1개 변경
                    // 서로 다른 비트 == XOR
                    long diff = (x ^ next) >> 2;
                    answer[i] = next | diff;
                }
            }
            return answer;
        }
    
}