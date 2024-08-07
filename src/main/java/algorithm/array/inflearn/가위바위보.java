package algorithm.array.inflearn;

import java.util.*;

public class 가위바위보 {
    public static ArrayList<String> solution(int[] arr1, int[] arr2) {
        ArrayList<String> answer = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            int a = arr1[i];
            int b = arr2[i];
            if ((a == 1 && b == 3) || (a == 2 && b == 1) || (a == 3 && b == 2)) {
                answer.add("A");
            } else if (a == b) {
                answer.add("D");
            } else {
                answer.add("B");
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = scanner.nextInt();
        }
        ArrayList<String> answer = solution(arr1, arr2);
        for (String s : answer) {
            System.out.println(s);
        }
    }
}
