import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int bytes = Integer.parseInt(reader.readLine());
        int repeat = bytes / 4;

        String aLong = "long ".repeat(repeat);
        System.out.println(aLong + "int");

    }

}