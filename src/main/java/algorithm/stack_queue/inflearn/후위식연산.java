package algorithm.stack_queue.inflearn;

import java.util.*;

public class 후위식연산 {
    public static int solution(String str) {
        Stack<Integer> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                if (c == '+') stack.push(operand1 + operand2);
                if (c == '-') stack.push(operand1 - operand2);
                if (c == '*') stack.push(operand1 * operand2);
                if (c == '/') stack.push(operand1 / operand2);
            } else stack.push(c - '0');
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solution(scanner.nextLine()));
    }
}
