package algorithm.binary_search.inflearn;

/**
 * 이진 탐색 조건 기준
 * 가까운 말의 거리
 * lt -> 최소 거리 : 1
 * rt -> 최대 거리 : 멀리 있는 좌표
 * mid값에 따라 배치할 수 있는 말의 수로 mid를 조절
 * 배치할 수 있는 말의 수가 크면
 * lt -> mid+1
 * 적으면
 * rt -> mid-1
 */

import java.util.*;

public class 마구간정하기 {

    public static int countHorse(int[] arr, int dis) {
        int before = 0;
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[before] >= dis) {
                before = i;
                count++;
            }
        }
        return count;
    }

    public static int solution(int n, int m, int[] arr) {
        int answer = 1;
        Arrays.sort(arr);
        int lt = 1, rt = arr[arr.length - 1];
        while (lt<=rt) {
            int mid = (lt + rt) / 2;
            if (countHorse(arr, mid) >= m) {
                answer = mid;
                lt = mid + 1;
            } else rt = mid - 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = scanner.nextInt();
        System.out.println(solution(n, m, arr));
    }
}
