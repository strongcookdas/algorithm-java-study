package algorithm.string.inflearn;

import java.util.*;

public class 특정문자뒤집기 {
    public static String solution(String str) {
        String answer = "";
        char[] s = str.toCharArray();
        int lt = 0;
        int rt = str.length() - 1;
        while (lt < rt) {
            if (!Character.isAlphabetic(s[lt])) lt++;
            else if (!Character.isAlphabetic(s[rt])) rt--;
            else {
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++; rt--;
            }
        }
        return String.valueOf(s);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solution(scanner.nextLine()));
    }
}
