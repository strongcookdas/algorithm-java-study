package algorithm.string.inflearn;

import java.util.*;

public class 회문문자열 {
    public static String solution(String str) {
        String answer = "YES";
//        str = str.toUpperCase();
//        for (int i = 0; i < str.length() / 2; i++) {
//            if (str.charAt(i) != str.charAt(str.length() - i - 1)) return answer = "NO";
//        }
        String tmp = new StringBuilder(str).reverse().toString();
        if (!str.equalsIgnoreCase(tmp)) return "NO";
        return answer;
    }

    public static void main(String[] argus) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solution(scanner.nextLine()));
    }
}
