class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for (int[] query : queries) {
            int tmp = arr[query[0]] ;
            arr[query[0]] = arr[query[1]] ;
            arr[query[1]] = tmp;
        }
        return arr;
    }
}