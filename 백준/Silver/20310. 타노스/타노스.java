import java.io.*;
import java.util.*;

public class Main {

    private static final char ONE = '1';
    private static final char ZERO = '0';


    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int ONE_COUNT = 0, ZERO_COUNT = 0;

        String input = reader.readLine();
        for (char c : input.toCharArray()) {
            if (c == ONE) {
                ONE_COUNT++;
            } else if (c == ZERO) {
                ZERO_COUNT++;
            }
        }

        int halfOneCount = ONE_COUNT / 2;
        int halfZeroCount = ZERO_COUNT / 2;


        int startIdx = 0;
        while (halfOneCount != 0) {
        		// startIdx값만 쏙 제거
            if (input.charAt(startIdx) == ONE) {
                input = input.substring(0, startIdx) + input.substring(startIdx + 1);
                halfOneCount--;
                startIdx = -1;
            }
            startIdx++;
        }

        int endIdx = input.length()-1; // substring Index 맞춰주기 위해 -1
        // substring 인수 하나만 넣으면 begin Index가 되기 때문에 input.length() 들어가면 OutOfRange
        while (halfZeroCount != 0) {
            if (input.charAt(endIdx) == ZERO) {
		            // endIdx값만 쏙 제거
                input = input.substring(0, endIdx) + input.substring(endIdx + 1);
                halfZeroCount--;
                endIdx = input.length();
            }
            endIdx--;
        }

        System.out.println(input);

    }

}