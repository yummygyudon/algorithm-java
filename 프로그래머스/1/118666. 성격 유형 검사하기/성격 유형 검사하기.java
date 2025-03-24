import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        ScoreBoard scoreBoard = new ScoreBoard();
        for (int i = 0; i < survey.length; i++) {
            String targetSurvey = survey[i];
            int targetSurveyChoice = choices[i];
            scoreBoard.add(targetSurvey, targetSurveyChoice);
        }
        return scoreBoard.getTotalResult();
    }
    static class ScoreBoard {
        final Map<String, Integer> map = new HashMap<>();
        public ScoreBoard() {
            this.map.putAll(Map.of(
                    "R", 0, "T", 0, "C", 0, "F", 0,
                    "J", 0, "M", 0, "A", 0, "N", 0
            ));
        }

        public void add(String survey, int choice) {
            String[] split = survey.split("");
            String left = split[0], right = split[1];
            if (choice == 4) {
                return;
            }
            if (choice < 4) {
                map.put(left, map.get(left) + + (4 - choice));
            } else {
                map.put(right, map.get(right) + choice - 4);
            }
        }
        public String getTotalResult() {
            StringBuilder builder = new StringBuilder();
            builder.append(getResult("R", "T"))
                    .append(getResult("C", "F"))
                    .append(getResult("J", "M"))
                    .append(getResult("A", "N"));
            return builder.toString();
        }

        private String getResult(String a, String b) {
            Integer aValue = map.get(a);
            Integer bValue = map.get(b);
            if (aValue > bValue) {
                return a;
            } else if (aValue < bValue) {
                return b;
            }
            return a.compareTo(b) > 0 ? b : a;
        }

    }
}
