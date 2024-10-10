package algorithm.brute_force.boj;

import java.util.*;

public class 수이어쓰기1790 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int K = kb.nextInt();

        수이어쓰기1790 main = new 수이어쓰기1790();
        System.out.println(main.solution(N, K));
    }

    private String solution(int N, int K) {
        int lt = 1, rt = N;
        int digit = -1;
        int answer = -1;
        while (rt >= lt) {
            int mid = (lt + rt) / 2;
            System.out.println(mid);
            int num = isNumber(mid, K);
            if (num != -1) {
                digit = num;
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        if (digit == -1) {
            return String.valueOf(-1);
        } else {
            String num = String.valueOf(answer);
            return String.valueOf(num.charAt(num.length() - (digit - K)));
        }
    }

    private int isNumber(int N, int K) {
        int mul = 9;
        int digit = 0;
        String num = String.valueOf(N);
        for (int i = 1; i < num.length(); i++) {
            digit += (i * mul);
            N -= mul;
            mul *= 10;
        }
        digit += (N * mul);
        if (digit >= K) {
            return digit;
        } else {
            return -1;
        }
    }
}
