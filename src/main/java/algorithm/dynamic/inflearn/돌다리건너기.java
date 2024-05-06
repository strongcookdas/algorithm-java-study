package algorithm.dynamic.inflearn;

import java.util.*;

public class 돌다리건너기 {
    static int[] dy;

    public static int solution(int n) {
        dy[1] = 1;
        dy[2] = 2;
        for (int i = 3; i <= n; i++) {
            dy[i] = dy[i - 2] + dy[i - 1];
        }
        return dy[n] + dy[n - 1];
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        dy = new int[n + 1];
        System.out.println(solution(n));
    }
}
