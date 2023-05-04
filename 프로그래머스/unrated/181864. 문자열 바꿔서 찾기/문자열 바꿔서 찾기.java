class Solution {
    public int solution(String myString, String pat) {
        String converted = "";
        for (String s : myString.split("")){
            if (s.equals("A")){
                converted += "B";
            }else {
                converted += "A";
            }
        }
        
        return converted.contains(pat) ? 1 : 0;
    }
}