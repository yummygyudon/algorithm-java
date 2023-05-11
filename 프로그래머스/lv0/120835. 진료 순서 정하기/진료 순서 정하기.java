import java.util.*;
class Solution {
    public int[] solution(int[] emergency) {
        int[] origin = new int[emergency.length];
        int[] answer = new int[emergency.length];
        for (int j = 0 ; j < emergency.length; j++) {
            origin[j] = emergency[j];
        }
        int rank = emergency.length;
        Arrays.sort(emergency) ;
//         System.out.println("origin : "+Arrays.toString(origin));
//         System.out.println("emergency : "+Arrays.toString(emergency));
        
        for (int num : emergency) {
            System.out.println("num : "+num);
            for (int i = 0 ; i < emergency.length ; i ++ ){
                if(origin[i] == num) {
                    answer[i] = rank;
                    break;
                }
            }
            // int idx = Arrays.asList(origin).indexOf(num);
            // answer[idx] = rank;
            rank--;
        }
        // System.out.println("answer : "+Arrays.toString(answer));
        // System.out.println(Arrays.toString(answer));
        return answer;
    }
}