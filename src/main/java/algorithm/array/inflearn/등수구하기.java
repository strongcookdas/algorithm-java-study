package algorithm.array.inflearn;

import java.util.*;

public class 등수구하기 {
    public static int[] solution(int[] arr) {
        int[] answer = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] < arr[j]) count++;
            }
            answer[i] = count;
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
        for (int tmp : solution(arr)) {
            System.out.print(tmp + " ");
        }
    }

}
