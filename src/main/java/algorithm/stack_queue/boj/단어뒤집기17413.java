package algorithm.stack_queue.boj;

import java.util.*;

public class 단어뒤집기17413 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String input = kb.nextLine();

        단어뒤집기17413 main = new 단어뒤집기17413();
        System.out.println(main.solution(input));
    }

    private String solution(String input) {
        StringBuilder sb = new StringBuilder("");
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char word = input.charAt(i);

            if (word == '<') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(word);
                while (true) {
                    word = input.charAt(++i);
                    sb.append(word);
                    if (word == '>') {
                        break;
                    }
                }
            } else if (word == ' ') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(word);
            } else {
                stack.push(word);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
