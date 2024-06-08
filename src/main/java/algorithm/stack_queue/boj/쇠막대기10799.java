package algorithm.stack_queue.boj;

import java.util.*;

public class 쇠막대기10799 {
    public static int solution(String str) { //스택 사용 x
        int count = 1, answer = 0;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ')') {
                count--;
                if (str.charAt(i - 1) == ')') answer++;
                else answer += count;
            } else count++;
        }
        return answer;
    }

    public static int solution2(String str) { //스택 사용
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        char before = str.charAt(0);
        for(char c : str.toCharArray()){
            if(c=='(') stack.push(c);
            else{
                stack.pop();
                if(before==')') answer++;
                else answer += stack.size();
            }
            before = c;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solution2(scanner.nextLine()));
    }
}
