package algorithm.math.boj;

import java.util.*;

public class 피보나치수5 {

    public static int solution(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        return solution(n - 1) + solution(n - 2);
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.println(solution(n));
    }
}
