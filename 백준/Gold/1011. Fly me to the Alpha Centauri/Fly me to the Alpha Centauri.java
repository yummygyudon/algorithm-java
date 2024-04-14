import java.util.*;
import java.io.*;


public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long t = Long.parseLong(reader.readLine());

        while(t>0){
            String[] input = reader.readLine().split(" ");
            long x = Long.parseLong(input[0]);
            long y = Long.parseLong(input[1]);

            long distance = y - x;
            long answer = 0;
            long cnt = 0;
            for(long i=1; answer<distance; i++){
                answer+=i;
                cnt++;
                if(answer>=distance){
                    break;
                }
                answer+=i;
                cnt++;
            }
            System.out.println(cnt);
            t--;
        }
    }
}