package algorithm.greedy.boj;
// 내 풀이
// 첫번째 -가 나오기 전까지의 수는 다 더한다.
// 나머지는 뺀다 -> 괄호를 치면 다 -로 변환할 수 있움

// 정석 풀이
// - 기준으로 split
// 첫번째 원소만 빼고 나머지 다 뺄셈

import java.util.*;

public class 잃어버린괄호1541 {
    /*
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String input = kb.nextLine();
        String[] inputs = input.split("(?=[+-])");
        잃어버린괄호1541 main = new 잃어버린괄호1541();
        System.out.println(main.solution(inputs));
    }
    private int solution(String[] inputs) {
        boolean flag = false;
        int answer = 0;
        for (String str : inputs) {
            int num = Integer.parseInt(str);
            if (!flag) {
                if (num < 0) {
                    flag = true;
                }
                answer += num;
            } else {
                if (num > 0) {
                    answer += (-num);
                } else {
                    answer += num;
                }
            }
        }
        return answer;
    }
    */

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String input = kb.nextLine();
        String[] minusSplit = input.split("-");

        int answer = 0;
        for (int i = 0; i < minusSplit.length; i++) {
            String[] plusSplit = minusSplit[i].split("\\+");
            if (i == 0) {
                for (String n : plusSplit) {
                    answer += Integer.parseInt(n);
                }
            } else {
                for (String n : plusSplit) {
                    answer -= Integer.parseInt(n);
                }
            }
        }

        System.out.println(answer);
    }

}
