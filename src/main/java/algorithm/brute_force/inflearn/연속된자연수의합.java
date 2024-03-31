package algorithm.brute_force.inflearn;

import java.util.*;

public class 연속된자연수의합 {
    public static int solution(int n) {
        int answer = 0;
        int cnt = 1;
        n--;
        while (n > 0) {
            cnt++;
            n -= cnt;
            if (n % cnt == 0) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solution(scanner.nextInt()));
    }
}
