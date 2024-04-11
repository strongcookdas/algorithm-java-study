package algorithm.sort.inflearn;

import java.util.*;

public class 중복확인 {
    public static String solution(int n, int[] arr) {
        String answer = "U";
        Arrays.sort(arr);
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] == arr[i]) return "D";
        }
        return answer;
    }

    public static void main(String[] argus) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = scanner.nextInt();
        System.out.println(solution(n, arr));
    }
}
