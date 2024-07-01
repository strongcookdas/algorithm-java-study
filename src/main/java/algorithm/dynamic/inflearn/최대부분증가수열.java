package algorithm.dynamic.inflearn;

import java.util.*;

public class 최대부분증가수열 {
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        arr = new int[N];
        dp = new int[N];
        Arrays.fill(dp, 1);
        for (int i = 0; i < N; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(solution());
    }

    public static int solution() {
        int answer = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            answer = Math.max(answer, dp[i]);
        }
        return answer;
    }
}
