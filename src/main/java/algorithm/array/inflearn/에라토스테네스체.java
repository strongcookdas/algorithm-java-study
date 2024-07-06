package algorithm.array.inflearn;

import java.util.Scanner;

public class 에라토스테네스체 {
    public static int solution(int n) {
        int answer = 0;
        int[] prime = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            if (prime[i] == 0) {
                answer++;
                for (int j = i + i; j <= n; j += i) {
                    prime[j] = 1;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solution(scanner.nextInt()));
    }
}
