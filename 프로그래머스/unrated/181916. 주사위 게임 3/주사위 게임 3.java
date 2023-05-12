import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int[] values = {a,b,c,d};
        int[] diceCount = new int[6];
        for(int v : values) {
            diceCount[v-1] += 1;
        }
        Arrays.sort(values);
        
        if(diceCount[a-1]==1&&diceCount[b-1]==1&&diceCount[c-1]==1){
            return values[0];
        }
        int answer = 0 ;
        for (int target = 1; target<=6; target++){
            if(diceCount[target-1] == 4) {
                // 해당 숫자만 4번 나왔을 때 : 모두 동일 할 때
                answer = 1111*target;
                break;
            }
            else if(diceCount[target-1] == 3){
                for(int other=1;other<=6; other++) {
                    if(diceCount[other-1] == 1){
                        answer = (int) Math.pow((10*target+other),2);
                        break;
                    }
                }
            } 
            else if(diceCount[target-1] == 2){
                int tmp = 1;
                for(int other=1;other<=6; other++) {
                    if (diceCount[other-1]==2){
                       if(target==other){
                            continue;
                        }
                        else {
                            answer = (target+other) * (int) Math.abs(other-target);
                            break;
                        } 
                    }
                    else if(diceCount[other-1] == 1){
                        tmp *= other;
                    }
                }
                if(answer == 0){ 
                    answer = tmp;
                }
            }
        }
        return answer;
    }
}