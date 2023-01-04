class Solution {
    public int[] solution(int denum1, int num1, int denum2, int num2) {
        int lcm = getLCM(num1, num2);
        int[] answer = new int[2];
        int finalDenum = calculate(denum1, num1, lcm) + calculate(denum2, num2, lcm);
        int resultGCD ;
        if(finalDenum >=lcm){
            resultGCD = getGCD(finalDenum, lcm);
        }else{
            resultGCD = getGCD(lcm, finalDenum);
        }
        answer[0] = finalDenum / resultGCD;
        answer[1] = lcm / resultGCD;
        return answer;
    }
    private int calculate(int denum, int num, int lcm){
        return denum * (lcm/num);
    }
    
    private int getLCM(int num1, int num2){
        if(num1 >= num2){
            return (num1*num2) / getGCD(num1, num2);
        }
        return (num1*num2) / getGCD(num2, num1);
    }
    
    private int getGCD(int a, int b){
        int r ;
        while(b != 0){ // 3, 2
            r = a % b ;  // 1 | 0
            a = b; // 2 | 1
            b = r; // 1 | 0
        }
        return a;
    }
}