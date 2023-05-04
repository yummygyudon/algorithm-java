class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        StringBuilder answer = new StringBuilder();
        String[] strings = my_string.split("");
        String[] over_strings = overwrite_string.split("");
        
        int alreadyAdded = 0 ;
        for(int i = 0 ; i < strings.length ; i++ ){
            if(i >= s && alreadyAdded < over_strings.length) {
                answer.append(over_strings[alreadyAdded]) ;
                alreadyAdded ++ ;
            } else {
                answer.append(strings[i]) ;
            }
        }
        return answer.toString();
    }
}
