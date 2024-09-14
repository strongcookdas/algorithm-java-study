package algorithm.dynamic.boj;

import java.util.*;

public class 제곱수의합1699 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int N = kb.nextInt();
        제곱수의합1699 main = new 제곱수의합1699();

        System.out.println(main.solution(N));

    }

    private int solution(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                int value = dp[i - (j * j)] + 1;
                if (value < dp[i]) {
                    dp[i] = value;
                }
            }
        }

        return dp[n];
    }
}
