import java.io.*;
import java.util.*;

public class Main {
    static int WORD_QUANTITY;
    static int WORD_LENGTH_LIMIT;
    static Map<String, Integer> WORD_COUNT = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        WORD_QUANTITY = Integer.parseInt(tokenizer.nextToken());
        WORD_LENGTH_LIMIT = Integer.parseInt(tokenizer.nextToken());
        List<String> words = new ArrayList<>();

        for (int i = 0; i < WORD_QUANTITY; i++) {
            String word = reader.readLine();
            if (word.length() >= WORD_LENGTH_LIMIT) {
                if (WORD_COUNT.containsKey(word)) {
                    int existCount = WORD_COUNT.get(word);
                    WORD_COUNT.replace(word, existCount + 1);
                } else {
                    words.add(word);
                    WORD_COUNT.put(word, 1);
                }
            }
        }
        words.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (WORD_COUNT.get(o1).equals(WORD_COUNT.get(o2))) {
                    if (o1.length() == o2.length()) {
                        for (int i = 0; i < o1.length(); i++) {
                            if (o1.charAt(i) != o2.charAt(i)) {
                                return Character.getNumericValue(o1.charAt(i)) - Character.getNumericValue(o2.charAt(i));
                            }
                        }
                    }
                    return -(o1.length() - o2.length());
                }
                return -(WORD_COUNT.get(o1) - WORD_COUNT.get(o2));
            }
        });
        for (String w : words) {
            writer = (BufferedWriter) writer.append(w).append("\n");
        }
        writer.flush();
        writer.close();
    }
}