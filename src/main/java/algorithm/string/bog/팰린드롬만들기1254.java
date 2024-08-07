package algorithm.string.bog;

import java.util.*;

public class 팰린드롬만들기1254 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String input = kb.nextLine();

        팰린드롬만들기1254 main = new 팰린드롬만들기1254();
        System.out.println(main.solution(input));
    }

    private int solution(String input) {
        int answer = input.length();
        StringBuilder sb = new StringBuilder(input);
        while (true) {
            String a = sb.reverse().toString();
            String b = sb.reverse().toString();
            if (a.equals(b)) {
                return answer;
            }
            sb.deleteCharAt(0);
            answer++;
        }
    }
}
