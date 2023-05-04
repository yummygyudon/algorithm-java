class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        return num_list.length > 10 ? getSumOf(num_list) : getMultiOf(num_list);
    }
    
    int getSumOf(int[] num_list) {
        int sum = 0;
        for(int num : num_list) {
            sum += num;
        }
        return sum;
    }
    int getMultiOf(int[] num_list) {
        int multi = 1;
        for(int num : num_list) {
            multi *= num;
        }
        return multi;
    }
}