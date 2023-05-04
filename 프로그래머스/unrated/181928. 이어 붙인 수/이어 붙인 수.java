class Solution {
    public int solution(int[] num_list) {
        String oddString = "";
        String evenString = "";
        for (int num : num_list) {
            if (num%2 == 0) {
                evenString += num ;
            } else {
                oddString += num ;
            }
        }
        return Integer.valueOf(oddString) + Integer.valueOf(evenString);
    }
}