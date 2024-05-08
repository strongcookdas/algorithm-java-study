package algorithm.brute_force.swea;

import java.util.*;

public class Flatten1208 {
    public static int solution(int n, int[] arr) {
        while (n-- > 0) {
            int max = arr[0], min = arr[0];
            int maxIdx = 0, minIdx = 0;
            for (int i = 1; i < 100; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                    maxIdx = i;
                }
                if (arr[i] < min) {
                    min = arr[i];
                    minIdx = i;
                }
            }

            if (max - min <= 1) {
                break;
            }

            arr[maxIdx]--;
            arr[minIdx]++;
        }

        int max = arr[0], min = arr[0];
        for (int i = 1; i < 100; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        return max - min;
    }


    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[] arr = new int[101];
            for (int i = 0; i < 100; i++) arr[i] = sc.nextInt();
            System.out.println("#" + test_case + " " + solution(n, arr));
        }
    }
}
