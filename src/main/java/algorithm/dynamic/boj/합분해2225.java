package algorithm.dynamic.boj;

import java.util.*;

public class 합분해2225 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        final int MOD = 1000000000;
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[][] dp = new int[n + 1][k];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < k; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < k; j++) {
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % MOD;
            }
        }
        System.out.println(dp[n][k - 1]);
    }
}
