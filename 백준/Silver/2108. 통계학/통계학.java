import java.util.*;
import java.io.*;

public class Main {

	    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int quan = Integer.parseInt(reader.readLine());
        int[] nums = new int[quan];
        int[] counts = new int[8001];


        int sum = 0;
        for (int i = 0; i < quan; i++) {
            int inputNum = Integer.parseInt(reader.readLine());
            nums[i] = inputNum;
            sum += inputNum;
            counts[inputNum + 4000]++;
        }
        Arrays.sort(nums);
        // 평균
        System.out.println(Math.round((float) sum / quan));
        // 중앙
        System.out.println(nums[quan/2]);

        // 최빈
        int maxCnt = -1;
        for (int count : counts) {
            if (maxCnt < count) {
                maxCnt = count;
            }
        }

        List<Integer> maxNums= new ArrayList<>();
        for (int i = 0; i < quan; i++) {
            if (counts[nums[i] + 4000] == maxCnt) {
                maxNums.add(nums[i]);
            }
        }
        if (maxNums.size() > maxCnt) {
            System.out.println(maxNums.get(maxCnt));
        } else {
            System.out.println(maxNums.get(0));
        }

        // 범위
            System.out.println(nums[quan - 1] - nums[0]);
        }
}