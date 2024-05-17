package algorithm.string.swea;

import java.util.*;

public class String1213 {

    public static int solution(String s, String str) {
        String temp = str.replaceAll(s, "");
        return (str.length() - temp.length())/s.length();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int t = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();
            String str = sc.nextLine();
            System.out.println("#"+t+" "+solution(s,str));
        }
    }

}
