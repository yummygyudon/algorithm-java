class Solution {
    public int solution(int price) {
        int rate = 0;
        if(price >= 500_000) {
            rate = 20;
        }else if(price >= 300_000) {
            rate = 10;
        }else if(price >= 100_000) {
            rate = 5;
        }
        return calcTotalPrice(price, rate) ;
    }
    
    int calcTotalPrice(int price, int rate){
        return (int)(Math.floor(price * (1-(rate*0.01))));
    }
}