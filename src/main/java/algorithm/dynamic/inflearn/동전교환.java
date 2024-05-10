package algorithm.dynamic.inflearn;

import java.util.*;

/*
특정 숫자의 배수들로 이루어진 동전들이 아니기 때문에 무조건 큰 값의 동전들로 바꿔주는 방식이 best가 아니다.
 */
public class 동전교환 {
    static int[] dy;
    static int n, m;
    public static int solution(int[] coins) {
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= m; j++) {
                dy[j] = Math.min(dy[j], dy[j - coins[i]] + 1);
            }
        }
        return dy[m];
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) coins[i] = kb.nextInt();
        m = kb.nextInt();
        dy = new int[m + 1];
        System.out.println(solution(coins));
    }
}
