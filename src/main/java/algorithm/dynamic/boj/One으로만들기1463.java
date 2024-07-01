package algorithm.dynamic.boj;

import java.util.*;

public class One으로만들기1463 {
    int[] dp;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        One으로만들기1463 main = new One으로만들기1463();
        System.out.println(main.solution(N));
    }

    private int solution(int n) {
        dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            if (i == 2 || i == 3) {
                dp[i] = 1;
            } else {
                int min = Integer.MAX_VALUE;
                if (i % 2 == 0) {
                    min = Math.min(min, dp[i / 2] + 1);
                }
                if (i % 3 == 0) {
                    min = Math.min(min, dp[i / 3] + 1);
                }
                min = Math.min(min, dp[i - 1] + 1);
                dp[i] = min;
            }
        }
        return dp[n];
    }
}
