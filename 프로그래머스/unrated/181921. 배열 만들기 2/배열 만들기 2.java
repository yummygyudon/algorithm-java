import java.util.* ;
import java.util.stream.* ;
class Solution {
    public int[] solution(int l, int r) {
//         List<String> ls = new ArrayList<>();
//         for (int num = l; num <= r ; i++){
//             if(isNotContainOther(num)){
//                 ls.add(String.valueOf(num))
//             }
//         }
        int[] result = IntStream.rangeClosed(l, r)
                            .filter(num -> isNotContainOther(num))
                            .toArray();
        int[] wrong = new int[1];
        wrong[0] = -1 ;
        return result.length == 0 ? wrong : result ;
    }
    
    boolean isNotContainOther(int num) {
        String numString = String.valueOf(num);
        for(String s : numString.split("")){
            if(s.equals("0") || s.equals("5")) {
                continue ;
            } else {
                return false ;
            }
        }
        return true ;
    }
}