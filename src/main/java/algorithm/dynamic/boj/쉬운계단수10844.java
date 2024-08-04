package algorithm.dynamic.boj;

import java.util.*;

public class 쉬운계단수10844 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        쉬운계단수10844 main = new 쉬운계단수10844();
        System.out.println(main.solution(N));
    }

    private int solution(int n) {
        if (n == 1) {
            return 9;
        }
        int mod = 1000000000;
        int[][] dp = new int[n][10];
        Arrays.fill(dp[0], 1);
        dp[0][0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j + 1] % mod;
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][j - 1] % mod;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
                }
            }
        }
        int answer = 0;
        for (int i = 0; i <= 9; i++) {
            answer = (answer + dp[n - 1][i]) % mod;
        }
        return answer;
    }
}
