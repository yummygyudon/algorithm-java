class Solution {
    public String solution(String my_string, int[][] queries) {
        for (int[] query : queries){
            String prefix = my_string.substring(0,query[0]); // <0 ~ query[0]-1> 영역
            String suffix = my_string.substring(query[1]+1); // <query[1]+1 ~ 끝> 영역
            // <query[0] ~ query[1]> 영역
            StringBuilder sb = new StringBuilder(my_string.substring(query[0],query[1]+1));
            // System.out.println("reverse : "+sb.toString());
            my_string = prefix + sb.reverse().toString() + suffix;
            // System.out.println(my_string);
        }
        return my_string;
    }
}