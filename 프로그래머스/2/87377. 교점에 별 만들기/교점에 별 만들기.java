import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        long maxX = Long.MIN_VALUE, maxY = Long.MIN_VALUE, minX = Long.MAX_VALUE, minY = Long.MAX_VALUE;
        List<long[]> crossPoints = new ArrayList<>();
        for (int i = 0; i < line.length - 1; i++) {
            int[] lineA = line[i];
            for (int k = i + 1; k < line.length; k++) {
                int[] lineB = line[k];
                if (!isSameOrParallel(lineA, lineB)) {
                    long[] crossPoint = getCrossPoint(lineA, lineB);
                    if (crossPoint != null) {
                        crossPoints.add(new long[]{crossPoint[1], crossPoint[0]});
                        maxX = Math.max(maxX, crossPoint[0]);
                        maxY = Math.max(maxY, crossPoint[1]);
                        minX = Math.min(minX, crossPoint[0]);
                        minY = Math.min(minY, crossPoint[1]);
                    }
                }
            }
        }
        int height = (int) (maxY - minY + 1);
        int width = (int) (maxX - minX + 1);
        char[][] map = new char[height][width];
        
        for (char[] row : map) Arrays.fill(row, '.');
        
        for (long[] point : crossPoints) {
            int tranY = (int) (point[0] - minY);
            int tranX = (int) (point[1] - minX);
            map[tranY][tranX] = '*';
        }
        
        String[] result = new String[height];
        for (int i = 0; i < height; i++) {
            result[i] = new String(map[height - 1 - i]);
        }
        return result;
    }

    public long[] getCrossPoint(int[] lineA, int[] lineB) {
        long A = lineA[0], B = lineA[1], E = lineA[2];
        long C = lineB[0], D = lineB[1], F = lineB[2];

        long denominator = A * D - B * C;
        if (denominator == 0) return null; // 평행

        long numeratorX = B * F - E * D;
        long numeratorY = E * C - A * F;

        if (numeratorX % denominator != 0 || numeratorY % denominator != 0) {
            return null; // 정수가 아닌 경우
        }

        return new long[]{numeratorX / denominator, numeratorY / denominator};
    }

    public boolean isSameOrParallel(int[] lineA, int[] lineB) {
        return (long) lineA[0] * lineB[1] == (long) lineA[1] * lineB[0];
    }
}
