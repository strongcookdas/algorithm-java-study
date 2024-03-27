package algorithm.array.inflearn;

import java.util.*;

public class 보이는학생 {
    public static int solution(int[] arr) {
        int max = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                count++;
                max = arr[i];
            }
        }
        return count;
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
