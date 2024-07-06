package algorithm.array.inflearn;

import java.util.ArrayList;
import java.util.Scanner;

public class 뒤집은소수 {
    public static ArrayList<Integer> solution(int max, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] prime = new int[max + 1];
        prime[0] = 1;
        prime[1] = 1;
        for (int i = 2; i <= max; i++) {
            if (prime[i] == 0) {
                for (int j = i + i; j <= max; j += i) {
                    prime[j] = 1;
                }
            }
        }

        for (int input : arr) {
            if (prime[input] == 0) {
                answer.add(input);
            }
        }
        return answer;
    }

    public static int reverseNum(int n) {
        int answer = 0;
        while (n > 0) {
            answer *= 10;
            answer += (n % 10);
            n /= 10;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            arr[i] = reverseNum(scanner.nextInt());
            max = Math.max(arr[i], max);
        }

        ArrayList<Integer> answer = solution(max, arr);
        for (Integer i : answer) {
            System.out.print(i + " ");
        }
    }
}
