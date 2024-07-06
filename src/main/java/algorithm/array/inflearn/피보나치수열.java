package algorithm.array.inflearn;

import java.util.*;

public class 피보나치수열 {
    public static void solution(int n) {
        int[] fibo = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == 1) {
                fibo[i] = 1;
            } else {
                fibo[i] = fibo[i - 1] + fibo[i - 2];
            }
        }
        for (int i : fibo) {
            System.out.print(i + " ");
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
