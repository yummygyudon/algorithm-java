import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(reader.readLine());
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < TC; i++) {

            int N = Integer.parseInt(reader.readLine());
            int teamQuantity = 0;
            int[] comeInSequence = new int[N+2];
            int[] teamMemberCount = new int[202]; // 각 팀의 들어온 멤버수
            int[] teamPoints = new int[202]; // 각팀의 총점
            int[] fifthMemberPoint = new int[202]; // 각팀의 5번째 선수 점수

            String[] inputs = reader.readLine().split(" ");
            for (int k = 1; k < N + 1; k++) {
                comeInSequence[k] = Integer.parseInt(inputs[k-1]); // 들어온 순서 기록
                teamMemberCount[comeInSequence[k]]++; // 해당 팀원 수 누계
                teamQuantity = Math.max(teamQuantity, comeInSequence[k]); // 1 ~ 최댓값
            }

            int score = 1;
            int[] teamMemberCheckCount = new int[202];
            for (int k = 1; k < N + 1; k++) {
                if (teamMemberCount[comeInSequence[k]] < 6) { // 자격 미달 팀일 경우
                    teamPoints[comeInSequence[k]] = Integer.MAX_VALUE;
                    fifthMemberPoint[comeInSequence[k]] = Integer.MAX_VALUE;
                // 아래 부턴 유효 팀들 대상
                } else {
                    // 상위 네 명의 주자의 점수만 합하면 됨
                    teamMemberCheckCount[comeInSequence[k]]++; // 해당 팀의 순서 도래
                    if (teamMemberCheckCount[comeInSequence[k]] < 5) {
                        teamPoints[comeInSequence[k]] += score;
                    } else if (teamMemberCheckCount[comeInSequence[k]] == 5) {
                        fifthMemberPoint[comeInSequence[k]] = score;
                    }
                    score++;
                }
            }

            int winnerTeam = 0;
            int minScore = Integer.MAX_VALUE;

            for (int k = 1; k < teamQuantity + 1; k++) {
                if (minScore > teamPoints[k]) {
                    minScore = teamPoints[k];
                    winnerTeam = k;
                } else if (minScore == teamPoints[k]
                        && fifthMemberPoint[k] < fifthMemberPoint[winnerTeam]) {
                    winnerTeam = k;
                }
            }
            builder.append(winnerTeam).append("\n");
        }
        System.out.println(builder);
    }
}