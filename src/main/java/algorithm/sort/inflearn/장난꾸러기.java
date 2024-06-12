package algorithm.sort.inflearn;

/**
 * 투포인터로 풀어보려고 했지만 반례에 대한 처리가 미흡
 * 그냥 정렬해서 풀었다.
 */

import java.util.Arrays;
import java.util.Scanner;

public class 장난꾸러기 {
    public static void solution(int n, int[] arr) {
        int[] sortArr = arr.clone();
        Arrays.sort(sortArr);

        int a = -1, b = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != sortArr[i]) {
                if (a == -1) a = i + 1;
                else b = i + 1;
            }
        }

        System.out.println(a + " " + b);
    }

    public static void main(String[] argus) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = scanner.nextInt();
        solution(n, arr);
    }
}