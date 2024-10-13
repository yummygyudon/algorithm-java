import java.io.*;
import java.util.*;

public class Main {
    
    static class Team{
        private int lastIndex;
        private int submitCount;
        private final int teamNumber;
        private final int[] scores;

        public Team(int teamNumber, int totalProblemCount) {
            this.teamNumber = teamNumber;
            this.scores = new int[totalProblemCount + 1];
            this.submitCount = 0;
            this.lastIndex = 0;
        }

        public void addSubmitCount() {
            submitCount++;
        }
        public void patchLastIndex(int idx) {
            lastIndex = Math.max(idx, lastIndex);
        }

        public void patchScore(int idx, int score) {
            scores[idx] = Math.max(scores[idx], score);
        }

        public int getTeamNumber() {
            return teamNumber;
        }

        public int getLastIndex() {
            return lastIndex;
        }
        public int getSubmitCount() {
            return submitCount;
        }
        public int getTotalScore() {
            return Arrays.stream(scores).sum();
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(reader.readLine());
        for (int i = 0; i < TC; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            int teamCount = Integer.parseInt(tokenizer.nextToken()),
                    problemCount = Integer.parseInt(tokenizer.nextToken()),
                    myTeamID = Integer.parseInt(tokenizer.nextToken()),
                    logCount = Integer.parseInt(tokenizer.nextToken());
            
            List<Team> teams = new ArrayList<>();
            for (int j = 1; j <= teamCount; j++) {
                teams.add(new Team(j, problemCount));
            }
            
            for (int m = 0; m < logCount; m++) {
                tokenizer = new StringTokenizer(reader.readLine(), " ");
                int id = Integer.parseInt(tokenizer.nextToken()),
                        pid = Integer.parseInt(tokenizer.nextToken()),
                        score = Integer.parseInt(tokenizer.nextToken());
                Team team = teams.get(id - 1);
                team.addSubmitCount();
                team.patchLastIndex(m);
                team.patchScore(pid, score);
            }
            
            teams.sort(new Comparator<Team>() {
                @Override
                public int compare(Team o1, Team o2) {
                    if (o1.getTotalScore() == o2.getTotalScore()) {
                        if (o1.getSubmitCount() == o2.getSubmitCount()) {
                            return o1.getLastIndex() - o2.getLastIndex();
                        } else {
                            return o1.getSubmitCount() - o2.getSubmitCount();
                        }
                    }
                    return -(o1.getTotalScore() - o2.getTotalScore());
                }
            });
            
            for (int j = 0; j < teamCount; j++) {
                if (teams.get(j).getTeamNumber() == myTeamID) {
                    System.out.println(j+1);
                    break;
                }
            }
        }
    }
    
}