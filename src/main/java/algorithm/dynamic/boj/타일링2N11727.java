package algorithm.dynamic.boj;

// 모듈러 연산을 해야 한다
// (a+b)%c == )(a%c + b%c) % c;

import java.util.Scanner;

// n일때 n-1의 경우의 수와 n-2의 경우의 수의 두배를 더한다.
public class 타일링2N11727 {
    int[] dp;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        타일링2N11727 main = new 타일링2N11727();
        System.out.println(main.solution(N));
    }

    private int solution(int n) {
        dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = 1;
            } else if (i == 2) {
                dp[i] = 3;
            } else {
                dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
            }
        }
        return dp[n];
    }
}
