package algorithm.string.bog;

import java.util.*;
import java.io.*;

public class 안정적인문자열4889 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        안정적인문자열4889 main = new 안정적인문자열4889();
        int t = 1;
        while (true) {
            String input = br.readLine();
            if (input.contains("-")) {
                break;
            }
            int result = main.solution(input);
            bw.write(String.format("%d. %d\n", t++, result));
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private int solution(String input) {
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        while (input.contains("{}")) {
            input = input.replace("{}", "");
        }

        for (int i = 0; i < input.length(); i++) {
            char temp = input.charAt(i);
            if (temp == '}') {
                if (stack.isEmpty()) {
                    answer++;
                    stack.push('{');
                } else {
                    stack.pop();
                }
            } else {
                stack.push('}');
            }
        }

        if (!stack.isEmpty()) {
            answer += (stack.size() / 2);
        }
        return answer;
    }
}
