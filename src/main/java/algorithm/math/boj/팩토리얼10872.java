package algorithm.math.boj;

import java.util.*;

public class 팩토리얼10872 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int N = kb.nextInt();
        팩토리얼10872 main = new 팩토리얼10872();

        System.out.println(main.solution(N));
    }

    private long solution(int n) {
        if (n == 0 || n == 1) {
            return 1L;
        }
        return n * solution(n - 1);
    }
}
