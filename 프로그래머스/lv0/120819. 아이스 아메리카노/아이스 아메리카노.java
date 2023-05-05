class Solution {
    public int[] solution(int money) {
        int[] answer = new int[2];
        int ableToBuy = (int) money / 5_500;
        answer[0] = ableToBuy;
        answer[1] = money - (ableToBuy*5_500);
        return answer;
    }
}