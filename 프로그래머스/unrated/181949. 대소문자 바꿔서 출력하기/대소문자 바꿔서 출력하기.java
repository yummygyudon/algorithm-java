import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        char[] alps = a.toCharArray();
        StringBuilder sb = new StringBuilder() ;
        for (char alp : alps) {
            if (Character.isUpperCase(alp)) {
                sb.append(Character.toString(alp).toLowerCase());
            } else {
                sb.append(Character.toString(alp).toUpperCase());
            }
        }
        System.out.println(sb.toString());
    }
}