class Solution {
    public int solution(String my_string, String is_suffix) {
        if (my_string.length() <= is_suffix.length()){
            return my_string.equals(is_suffix) ? 1 : 0 ;
        }
        // String[] splitStr = my_string.split("");
        // new String[my_string.length - 1];
        int startIdx = my_string.length() - is_suffix.length();
        for (int i = 0 ; i < is_suffix.length()-1 ; i ++ ){
            if ( my_string.charAt(startIdx) == is_suffix.charAt(i) ) {
                startIdx ++ ;
                continue ;
            }
            return 0 ;
        }
//         String splitStr = splitStr[]
        
//         int answer = 0;
        
        return 1;
    }
}