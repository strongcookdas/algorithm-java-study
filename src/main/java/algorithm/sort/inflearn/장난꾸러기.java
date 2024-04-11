package algorithm.sort.inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class 장난꾸러기 {
    public static void solution(int n, int[] arr) {
        int[] tmp = arr.clone();
        Arrays.sort(tmp);
        for (int i = 0; i < n; i++) {
            if (arr[i] != tmp[i]) System.out.print((i + 1) + " ");
        }
    }

    public static void main(String[] argus) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = scanner.nextInt();
        solution(n, arr);
    }
}
