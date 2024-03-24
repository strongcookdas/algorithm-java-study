package algorithm.string.inflearn;

import java.util.Scanner;

public class 팰린드롬 {
    public static String solution(String s) {
        String answer = "YES";
        s = s.toUpperCase().replaceAll("[^A-Z]", "");
        String tmp = new StringBuilder(s).reverse().toString();
        if (!s.equals(tmp)) return "NO";
        return answer;
    }

    public static void main(String[] argus) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solution(scanner.nextLine()));
    }
}
