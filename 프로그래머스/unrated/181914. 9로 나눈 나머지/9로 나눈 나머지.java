class Solution {
    public int solution(String number) {
        int answer = 0;
        for (String s : number.split("")){
            answer+= Integer.valueOf(s);
        }
        return (int)answer%9;
    }
}