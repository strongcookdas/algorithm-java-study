package algorithm.stack.boj;

import java.util.*;
//Stack 안쓰고 해결한 버전
public class 쇠막대기 {
    public static int solution(String s) {
        int answer = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else {
                if (s.charAt(i - 1) == '(') {
                    answer += (--count);
                } else {
                    answer++;
                    count--;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solution(scanner.nextLine()));
    }
}
