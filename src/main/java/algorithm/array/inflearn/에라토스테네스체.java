package algorithm.array.inflearn;

import java.util.Scanner;

public class 에라토스테네스체 {
    public static int solution(int n) {
        int answer = 0;
        int[] arr = new int[n+1];
        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) answer++;
            else continue;
            int idx = i;
            while (idx <= n) {
                arr[idx] = 1;
                idx += i;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solution(scanner.nextInt()));
    }
}
