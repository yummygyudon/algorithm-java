class Solution {
    public int solution(String skill, String[] skill_trees) {
            int answer = 0;

            for (String tree : skill_trees) {
                if (isSkillTreePossible(skill, tree)) {
                    answer++;
                }
            }

            return answer;
        }

        private boolean isSkillTreePossible(String skill, String tree) {
            StringBuilder checks = new StringBuilder();
            for (String s : tree.split("")) {
                if (skill.contains(s)) {
                    checks.append(s);
                }
            }
            // System.out.println(checks);
            return skill.startsWith(checks.toString());
        }
}