package algorithm.dynamic.boj;

// 모듈러 연산을 해야 한다
// (a+b)%c == )(a%c + b%c) % c;

import java.util.*;

public class 타일링2N11726 {
    int[] dp;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        타일링2N11726 main = new 타일링2N11726();
        System.out.println(main.solution(N));
    }

    private int solution(int n) {
        dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i < 3) {
                dp[i] = i;
            } else {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
            }
        }
        return dp[n];
    }
}
