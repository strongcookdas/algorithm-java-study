package algorithm.two_pointer.inflearn;

import java.util.*;

/*
처음 풀이법 결국 n^2
슬라이딩 윈도우 사용
 */
public class 최대매출 {
    public static int solution(int n, int k, int[] arr) {
        int answer = 0;
//        int p1 = 0, p2 = n - 1;
//        while (p1 < p2) {
//            int sum1 = 0, sum2 = 0;
//            int count = 0;
//            while (count < k) {
//                sum1 += arr[p1 + count++];
//            }
//            count = 0;
//            while (count < k) {
//                sum2 += arr[p2 - count++];
//            }
//            answer = Math.max(sum1, answer);
//            answer = Math.max(sum2, answer);
//            p1++;
//            p2--;
//        }
        int sum = 0;
        for (int i = 0; i < k; i++) sum += arr[i];
        answer = sum;
        for (int i = k; i < n; i++) {
            sum += (arr[i] - arr[i - k]);
            answer = Math.max(answer, sum);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int k = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(solution(n, k, arr));
    }
}
