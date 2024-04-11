package algorithm.sort.inflearn;

import java.util.*;

public class 뮤직비디오 {// 다시 풀어야하는 문제
    public static int count(int[] arr, int capacity) {
        int sum = 0, cnt = 1;
        for (int i : arr) {
            if (sum + i > capacity) {
                cnt++;
                sum = i;
            } else sum += i;
        }
        return cnt;
    }

    public static int solution(int n, int m, int[] arr) {
        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(arr, mid) <= m) {
                answer = mid;
                rt = mid - 1;
            } else lt = mid + 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = kb.nextInt();
        System.out.println(solution(n, m, arr));
    }
}
