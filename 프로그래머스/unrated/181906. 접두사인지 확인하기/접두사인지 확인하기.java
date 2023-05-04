class Solution {
    public int solution(String my_string, String is_prefix) {
        String[] strings = my_string.split("");
        String[] prefixStrings = is_prefix.split("");
        if (strings.length >= prefixStrings.length) {
            for (int i = 0; i < prefixStrings.length ; i ++){
                if(!strings[i].equals(prefixStrings[i])) {
                    return 0 ;
                }
            }
        } else {
            return 0 ;
        }
        
        return 1;
    }
}