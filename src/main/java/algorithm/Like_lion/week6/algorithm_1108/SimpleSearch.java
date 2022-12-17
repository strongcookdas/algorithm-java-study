package algorithm.Like_lion.week6.algorithm_1108;

import java.util.Scanner;

public class SimpleSearch {
    public int solution(int[] arr, int number) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int[] arr = new int[cnt];
        int idx = 0;
        while (cnt-- != 0) {
            arr[idx++] = sc.nextInt();
        }
        int number = sc.nextInt();
        System.out.println(new SimpleSearch().solution(arr, number));
    }
}
