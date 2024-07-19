package algorithm.binary_search.inflearn;

import java.util.*;

public class 뮤직비디오 {

    public static int solution(int n, int m, int[] arr) {
        int lt = 1;
        int rt = 10000;
        int answer = Integer.MIN_VALUE;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(mid, arr) <= m) {
                rt = mid - 1;
                answer = mid;
            } else {
                lt = mid + 1;
            }
        }
        return answer;
    }

    private static int count(int mid, int[] arr) {
        int count = 1;
        int sum = 0;
        for (int n : arr) {
            if (sum + n > mid) {
                count++;
                sum = n;
            } else {
                sum += n;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(solution(n, m, arr));
    }
}
