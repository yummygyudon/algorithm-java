class Solution {
    public int[] solution(int[] numbers, int num1, int num2) {
        int index = 0; 
        boolean isStart = false;
        int[] answer = new int[num2-num1+1];
        for(int i = 0; i < numbers.length; i++ ){
            if(i == num1) {
                isStart = true;
                answer[index] = numbers[i] ;
                index ++ ;
            } else if(i < num2 && isStart) {
                answer[index] = numbers[i] ;
                index ++ ;
            } else if(i == num2 && isStart) {
                answer[index] = numbers[i] ;
                break;
            }
        }
        return answer;
    }
}