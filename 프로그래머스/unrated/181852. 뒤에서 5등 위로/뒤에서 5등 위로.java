import java.util.* ;
class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length - 5];
        // List<Integer> numList = Arrays.asList(num_list);
        // List<Integer> sortList = Arrays.sort(numList, (i1, i2) -> i1-i2);
        // for(Integer i : sortList) {
        //     System.out.println(i);
        // }
        Arrays.sort(num_list);
        int index = 0;
        for (int i = 5; i < num_list.length; i++) {
            answer[index] = num_list[i] ;
            index ++;
        }
        return answer;
        
    }
}