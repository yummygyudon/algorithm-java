class Solution {
    public int[] solution(int[] num_list, int n) {
        // int limitQuantity = 
        int[] answer = new int[(int)Math.ceil((double)num_list.length/n)];
        int index = 0;
        for(int i = 0; i < num_list.length; i+=n) {
            answer[index] =  num_list[i] ;
            index++;
        }
        return  answer ;
    }
}