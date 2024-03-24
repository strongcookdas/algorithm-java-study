package algorithm.string.inflearn;

import java.util.*;

public class 문자열압축 {
    public static String solution(String str) {
        StringBuilder builder = new StringBuilder("");
        str = str+" ";
        int count = 1;
        char tmp = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == tmp) count++;
            else {
                builder.append(tmp);
                if (count > 1) builder.append(count);
                tmp = str.charAt(i);
                count = 1;
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solution(scanner.nextLine()));
    }
}
