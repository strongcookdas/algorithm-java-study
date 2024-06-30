package algorithm.math.boj;

import java.util.Scanner;

public class 조합0의개수2004 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int M = kb.nextInt();
        조합0의개수2004 main = new 조합0의개수2004();
        System.out.println(main.solution(N, M));
    }

    private int countN(int i, int n) {
        int count = 0;
        for (long j = n; j <= i; j *= n) {
            count += i / j;
        }
        return count;
    }

    private int solution(int n, int m) {
        if (m == 0 || m == n) {
            return 0;
        }
        int count2 = countN(n, 2) - countN(m, 2) - countN(n - m, 2);
        int count5 = countN(n, 5) - countN(m, 5) - countN(n - m, 5);
        return Math.min(count2, count5);
    }
}

// 메모리 초과
// 접근 방식을 달리 해야함
// 인수 분해 이용


