package algorithm.stack_queue.inflearn;

import java.util.*;

public class 올바른괄호 {
    public static String solution(String str) {
        String answer = "YES";
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(') stack.push(c);
            else {
                if (stack.isEmpty()) return "NO";
                stack.pop();
            }
        }
        if (!stack.isEmpty()) return "NO";
        return answer;
    }

    public static String solution2(String str) {
        int sum = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') sum++;
            if (c == ')') sum--;
            if (sum < 0) return "NO";
        }
        return (sum == 0) ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(solution2(str));
    }
}
