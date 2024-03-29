package algorithm.two_pointer.boj;

import java.util.*;

public class Boj2018수들의합 {
    public static int solution(int n) {
        int answer = 0;
        int sum = 0;
        int p1 = 1, p2 = 1;
        // 7 + 8 일 경우까지 생각해서 n+1 경계값
        while (p1 + p2 <= (n+1)) {
            if (sum == n) {
                answer++;
                sum -= (p1++);
            } else if (sum < n) {
                sum += (p2++);
            } else {
                sum -= (p1++);
            }
        }
        return answer+1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(solution(n));
    }
}
