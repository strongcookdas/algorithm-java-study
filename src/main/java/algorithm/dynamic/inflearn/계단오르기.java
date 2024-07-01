package algorithm.dynamic.inflearn;

import java.util.*;

public class 계단오르기 {
    static int[] dp;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        System.out.println(solution(N));
    }

    private static int solution(int n) {
        dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }
}
