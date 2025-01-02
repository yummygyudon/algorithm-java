import java.util.*;

class Solution {
    static Map<String, Map<String, Integer>> statuses;
    static Map<String, Integer> giftRate;
    
    public int solution(String[] friends, String[] gifts) {
        statuses = new HashMap<>();
        giftRate = new HashMap<>();
        
        for (String name : friends) {
            statuses.put(name, new HashMap<>());
        }
        
        StringTokenizer tokenizer;
        for (String pair : gifts) {
            tokenizer = new StringTokenizer(pair, " ");
            String giver = tokenizer.nextToken();
            String receiver = tokenizer.nextToken();
            Map<String, Integer> giverStatus = statuses.get(giver);
            if (giverStatus.containsKey(receiver)) {
                giverStatus.replace(receiver, giverStatus.get(receiver) + 1);
            } else {
                giverStatus.put(receiver, 1);
            }
        }
        
        for (String target : friends) {
            Map<String, Integer> targetStatus = statuses.get(target);
            int giveCnt = targetStatus.values().stream().mapToInt(i -> i).sum();
            int receiveCnt = 0;
            for (String friend : statuses.keySet()) {
                if (!friend.equals(target) && statuses.get(friend).containsKey(target)) {
                    receiveCnt += statuses.get(friend).get(target);
                }
            }
            giftRate.put(target, giveCnt - receiveCnt);
        }
        
        int maxCnt = 0;
        for (String target : friends) {
            int nextMonthCnt = 0;
            for (String targetGiveFriend : statuses.keySet()) {
                if (!targetGiveFriend.equals(target)) {
                    if ((!statuses.get(targetGiveFriend).containsKey(target) && !statuses.get(target).containsKey(targetGiveFriend))) {
                        if (giftRate.get(target) > giftRate.get(targetGiveFriend)) {
                            nextMonthCnt++;
                        }
                    } else {
                        int friendGiveTargetCnt = statuses.get(targetGiveFriend).getOrDefault(target, 0);
                        int targetGiveFriendCnt = statuses.get(target).getOrDefault(targetGiveFriend, 0);
                        if (targetGiveFriendCnt > friendGiveTargetCnt) {
                            nextMonthCnt++;
                        } else if (targetGiveFriendCnt == friendGiveTargetCnt) {
                            if (giftRate.get(target) > giftRate.get(targetGiveFriend)) {
                                nextMonthCnt++;
                            }
                        }
                    }
                }
            }
            maxCnt = Math.max(maxCnt, nextMonthCnt);
        }
        return maxCnt;

    }
}