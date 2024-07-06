package algorithm.array.inflearn;

import java.util.*;

public class 점수계산 {
    public static int solution(int[] arr) {
        int answer = 0;
        int count = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count = 1;
            } else {
                answer += count++;
            }
        }
        return answer;
    }

    public static void main(String[] argus) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(solution(arr));
    }
}
