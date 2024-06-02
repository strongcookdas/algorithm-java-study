package algorithm.two_pointer.inflearn;


/*
- 반복문으로 매출액 합을 구하면 시간 초과
- 슬라이딩 윈도우 사용
- O(n)으로 구할 수 있다.
 */

import java.util.*;

public class 최대매출 {
    public int solution(int N, int K, int[] arr) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < N - 1; i++) {
            if (i < K) sum += arr[i];
            else {
                sum -= arr[i - K];
                sum += arr[i];
            }
            max = Math.max(sum, max);
        }
        return max;
    }

    public static void main(String[] args) {
        최대매출 main = new 최대매출();
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int K = kb.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = kb.nextInt();
        System.out.println(main.solution(N, K, arr));
    }
}
