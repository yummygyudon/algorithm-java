class Solution {
    public String solution(String str1, String str2) {
        char[] strings1 = str1.toCharArray();
        char[] strings2 = str2.toCharArray();
        int fullSize = strings1.length + strings2.length ; 
        int index1 = 0;
        int index2 = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < fullSize ; i++) {
            if (i%2==0) {
                sb.append(strings1[index1]) ;
                index1 ++ ;
            } else {
                sb.append(strings2[index2]) ;
                index2 ++ ;
            }
        }
        return sb.toString();
    }
}