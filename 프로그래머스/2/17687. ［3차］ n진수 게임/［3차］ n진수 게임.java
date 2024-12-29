class Solution {
    
    public String solution(int n, int t, int m, int p) {
        int time = 0;
        StringBuilder full = new StringBuilder();
        while (full.length() < (t*m)) {
            String targetValue = Integer.toString(time, n);
            full.append(targetValue.toUpperCase());
            time++;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int index = (i * m) + (p - 1);
            result.append(full.charAt(index));
        }
        // System.out.println(full);
        // System.out.println(result);
//
        return result.toString();
    }
}