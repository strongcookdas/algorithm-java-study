package algorithm.array.inflearn;

import java.util.*;

public class 보이는학생 {
    public static int solution(int[] arr) {
        int max = Integer.MIN_VALUE;
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                answer++;
                max = arr[i];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(solution(arr));
    }
}
