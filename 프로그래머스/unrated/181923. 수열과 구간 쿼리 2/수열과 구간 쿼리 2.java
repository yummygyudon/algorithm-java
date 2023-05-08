class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        int queryIdx = 0 ;
        int MAX = 1_000_000 ;
        for (int[] query : queries) {
            boolean isPossible = false ;
            int minValue = MAX ;
            for (int s = query[0] ; s <= query[1] ; s++) {
                if(arr[s] > query[2]) {
                    minValue = Math.min(arr[s], minValue) ;
                    isPossible = true;
                }
            }
            if (!isPossible) {
                answer[queryIdx] = -1;
            } else {
                answer[queryIdx] = minValue;
            }
            queryIdx ++ ;
        }
        return answer;
    }
    
}