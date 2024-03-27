package algorithm.array.inflearn;

import java.util.*;

public class 피보나치수열 {
    public static void solution(int n) {
//        int[] answer = new int[n];
//        answer[0] = 1;
//        answer[1] = 1;
//        for (int i = 2; i < n; i++) {
//            answer[i] = answer[i - 1] + answer[i - 2];
//        }
        int a = 1, b = 1;
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == 1) {
                System.out.print(1 + " ");
                continue;
            }
            int c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
//        for (int i : solution(n)) {
//            System.out.print(i + " ");
//        }
        solution(n);
    }
}
