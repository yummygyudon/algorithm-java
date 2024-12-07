import java.io.*;
import java.util.*;

public class Main {

    private static LinkedList<Character> WORDS = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = reader.readLine();
        for (int i = 0; i < word.length(); i++) {
            WORDS.add(word.charAt(i));
        }
        int cnt = Integer.parseInt(reader.readLine());
        ListIterator<Character> cursor = WORDS.listIterator();
        while (cursor.hasNext()) {
            cursor.next();
        }
        for (int i = 0; i < cnt; i++) {
            String command = reader.readLine();
            switch (command.charAt(0)) {
                case 'L' :
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                    }
                    break;
                case 'D' :
                    if (cursor.hasNext()) {
                        cursor.next();
                    }
                    break;
                case 'B' :
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                        cursor.remove();
                    }
                    break;
                case 'P' :
                    char insertAlphabet = command.charAt(2);
                    cursor.add(insertAlphabet);
                    break;
                default :
                    break;
            }
        }
        for (char alp : WORDS) {
            writer.write(alp);
        }
        writer.flush();
        writer.close();
    }
}
