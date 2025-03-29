import java.util.*;

class Solution {
    static Map<String, String> FILTER_LANGUAGE_PARAMETERS = Map.of(
            "java", "j",
            "cpp", "c",
            "python", "p"
    );
    static Map<String, String> FILTER_POSITION_PARAMETERS = Map.of(
            "backend", "b",
            "frontend", "f"
    );
    static Map<String, String> FILTER_LEVEL_PARAMETERS = Map.of(
            "junior", "j",
            "senior", "s"
    );
    static Map<String, String> FILTER_FOOD_PARAMETERS = Map.of(
            "chicken", "c",
            "pizza", "p"
    );
    static int QUERY_RESULT_COUNT;
    static String QUERY_TEMP_SCORE;
    static String[] QUERY_TEMP_EXCLUDE_SCORE;
    static Map<String, List<Integer>> FILTERED_USER_SCORE_HISTORY = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        for (String i : info) {
            registerHistory(i);
        }
        sortEachHistory();
        for (int i = 0; i < query.length; i++) {
            QUERY_RESULT_COUNT = 0;
            String[] queryDetails = query[i].replaceAll(" and", "").split(" ");
            QUERY_TEMP_SCORE = queryDetails[4];
            QUERY_TEMP_EXCLUDE_SCORE = Arrays.copyOfRange(queryDetails, 0, 4);
            applyQuery(0, "");
            answer[i] = QUERY_RESULT_COUNT;
        }

        return answer;
    }

    private void registerHistory(String historyInfo) {
        String[] infos = historyInfo.split(" ");
        StringBuilder infoKey = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            switch (i) {
                case 0 -> infoKey.append(FILTER_LANGUAGE_PARAMETERS.get(infos[i]));
                case 1 -> infoKey.append(FILTER_POSITION_PARAMETERS.get(infos[i]));
                case 2 -> infoKey.append(FILTER_LEVEL_PARAMETERS.get(infos[i]));
                case 3 -> infoKey.append(FILTER_FOOD_PARAMETERS.get(infos[i]));
            }
        }
        String key = infoKey.toString();
        int score = Integer.parseInt(infos[4]);
        if (FILTERED_USER_SCORE_HISTORY.containsKey(key)) {
            FILTERED_USER_SCORE_HISTORY.get(key).add(score);
        } else {
            List<Integer> scores = new ArrayList<>(List.of(score));
            FILTERED_USER_SCORE_HISTORY.put(key, scores);
        }
    }

    private void sortEachHistory() {
        for (String historyKey : FILTERED_USER_SCORE_HISTORY.keySet()) {
            Collections.sort(FILTERED_USER_SCORE_HISTORY.get(historyKey));
        }
    }

    private void applyQuery(int queryDepth, String searchUsersKey) {
        if (queryDepth == 4) {
            if (!FILTERED_USER_SCORE_HISTORY.containsKey(searchUsersKey)) {
                return;
            }
            List<Integer> targetUserScores = FILTERED_USER_SCORE_HISTORY.get(searchUsersKey);
            int start = 0, end = targetUserScores.size();
            int target = Integer.parseInt(QUERY_TEMP_SCORE);
            while (start < end) {
                int mid = (start + end) / 2;
                if (targetUserScores.get(mid) >= target) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
            QUERY_RESULT_COUNT += targetUserScores.size() - start;
            return;
        }

        if (QUERY_TEMP_EXCLUDE_SCORE[queryDepth].equals("-")) {
            switch (queryDepth) {
                case 0 -> {
                    applyQuery(queryDepth + 1, searchUsersKey + "j");
                    applyQuery(queryDepth + 1, searchUsersKey + "c");
                    applyQuery(queryDepth + 1, searchUsersKey + "p");
                }
                case 1 -> {
                    applyQuery(queryDepth + 1, searchUsersKey + "b");
                    applyQuery(queryDepth + 1, searchUsersKey + "f");
                }
                case 2 -> {
                    applyQuery(queryDepth + 1, searchUsersKey + "j");
                    applyQuery(queryDepth + 1, searchUsersKey + "s");
                }
                case 3 -> {
                    applyQuery(queryDepth + 1, searchUsersKey + "c");
                    applyQuery(queryDepth + 1, searchUsersKey + "p");
                }
            }
        } else {
            switch (queryDepth) {
                case 0 -> {
                    applyQuery(queryDepth + 1, searchUsersKey + FILTER_LANGUAGE_PARAMETERS.get(QUERY_TEMP_EXCLUDE_SCORE[queryDepth]));
                }
                case 1 -> {
                    applyQuery(queryDepth + 1, searchUsersKey + FILTER_POSITION_PARAMETERS.get(QUERY_TEMP_EXCLUDE_SCORE[queryDepth]));
                }
                case 2 -> {
                    applyQuery(queryDepth + 1, searchUsersKey + FILTER_LEVEL_PARAMETERS.get(QUERY_TEMP_EXCLUDE_SCORE[queryDepth]));
                }
                case 3 -> {
                    applyQuery(queryDepth + 1, searchUsersKey + FILTER_FOOD_PARAMETERS.get(QUERY_TEMP_EXCLUDE_SCORE[queryDepth]));
                }
            }
        }

    }
}