import java.util.*;

class Solution {
    static Map<String, int[]> commands = Map.of(
        "U", new int[]{-1, 0},
        "D", new int[]{1, 0},
        "R", new int[]{0, 1},
        "L", new int[]{0, -1}
    );
    static Map<String, String> opposites = Map.of(
        "U", "D",
        "D", "U",
        "R", "L",
        "L", "R"
    );
    
    public int solution(String dirs) {
        int answer = 0;
            Set<String> already = new HashSet<>();
            int x = 0, y = 0;

            for (String command : dirs.split("")) {
                int[] c = commands.get(command);
                int next_y = y + c[0];
                int next_x = x + c[1];
                if (next_y >= -5 && next_y <= 5 && next_x >= -5 && next_x <= 5) {
                    String next_y_s = String.valueOf(next_y),
                            next_x_s = String.valueOf(next_x);

                    String moveBefore =  opposites.get(command) + y + x;
                    String moveAfter =  command + next_y + next_x;
                    x = next_x;
                    y = next_y;
                    if (already.contains(moveBefore) || already.contains(moveAfter)) {
                        continue;
                    }
                    already.add(moveBefore);
                    already.add(moveAfter);
                    answer++;
                }
            }
            return answer;
    }
}