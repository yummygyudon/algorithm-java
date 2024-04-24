import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = reader.readLine().split(" ");
        int ROUND = Integer.parseInt(inputs[0]);
        int JIMIN = Integer.parseInt(inputs[1]);
        int HANSU = Integer.parseInt(inputs[2]);

        int count = 0;
        while (JIMIN != HANSU) {
//            System.out.println("현재 지민 : "+JIMIN+" / 현재 한수 : "+HANSU);
            JIMIN -= JIMIN / 2;
            HANSU -= HANSU / 2;
            count++;
        }
        System.out.println(count);
    }
}