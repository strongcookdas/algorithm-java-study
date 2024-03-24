package algorithm.string.inflearn;

import java.util.*;

public class 가장짧은문자거리 {
    public static int[] solution(String str, char c) {
        int[] answer = new int[str.length()];
        int p = 1000;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) p = 0;
            answer[i] = p++;
        }

        p=1000;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == c) p = 0;
            if (answer[i] > p) answer[i] = p;
            p++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] answer = solution(scanner.next(), scanner.next().charAt(0));
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }
}
