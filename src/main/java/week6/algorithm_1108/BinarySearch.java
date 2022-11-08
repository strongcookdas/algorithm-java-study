package week6.algorithm_1108;

import java.util.Scanner;

public class BinarySearch {
    public int solution(int[] arr, int target) {
        int startIdx = 0;
        int endIdx = arr.length - 1;
        int ans = -1;
        int midIdx = arr.length / 2;
        while (endIdx >= startIdx) {
            if (target > arr[midIdx])
                startIdx = midIdx + 1;
            else if (target < arr[midIdx])
                endIdx = midIdx - 1;
            else return midIdx + 1;
            midIdx = (startIdx + endIdx) / 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[cnt];
        int idx = 0;
        while (cnt-- != 0) {
            arr[idx++] = sc.nextInt();
        }
        System.out.println(new BinarySearch().solution(arr, target));
    }
}
