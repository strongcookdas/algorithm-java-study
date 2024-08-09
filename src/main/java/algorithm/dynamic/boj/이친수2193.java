package algorithm.dynamic.boj;

import java.util.*;
import java.math.*;

public class 이친수2193 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int N = kb.nextInt();
        이친수2193 main = new 이친수2193();

        System.out.println(main.solution(N));
    }

    private String solution(int n) {
        BigInteger[][] dp = new BigInteger[n + 1][2];

        dp[1][0] = new BigInteger("0");
        dp[1][1] = new BigInteger("1");

        for (int i = 2; i <= n; i++) {
            dp[i][1] = dp[i - 1][0];
            dp[i][0] = dp[i - 1][0].add(dp[i - 1][1]);
        }

        return dp[n][0].add(dp[n][1]).toString();
    }
}
