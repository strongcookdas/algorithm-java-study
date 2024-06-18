package algorithm.brute_force.boj;

import java.util.*;

public class 날짜계산1476 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String[] inputs = kb.nextLine().split(" ");
        int E = Integer.parseInt(inputs[0]);
        int S = Integer.parseInt(inputs[1]);
        int M = Integer.parseInt(inputs[2]);

        날짜계산1476 main = new 날짜계산1476();

        System.out.println(main.solution(E, S, M));
    }

    private int solution(int e, int s, int m) {
        int[] arr = new int[3];
        int[] rule = new int[]{16, 29, 20};
        int answer = 0;
        while (arr[0] != e || arr[1] != s || arr[2] != m) {
            for (int i = 0; i < arr.length; i++) {
                arr[i]++;
                if (arr[i] == rule[i]) {
                    arr[i] = 1;
                }
            }
            answer++;
        }
        return answer;
    }
}
