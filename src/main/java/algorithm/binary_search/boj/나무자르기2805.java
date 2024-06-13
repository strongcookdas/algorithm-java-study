package algorithm.binary_search.boj;
/**
 * 이진 탐색
 * 찾아야 하는 값
 * 절단기 설정 높이 값
 * 탐색 기준
 * 총 벌목한 나무의 길이
 */

import java.util.*;

public class 나무자르기2805 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int M = kb.nextInt();
        kb.nextLine();
        String[] inputs = kb.nextLine().split(" ");
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) arr[i] = Long.parseLong(inputs[i]);

        나무자르기2805 main = new 나무자르기2805();
        System.out.println(main.solution(arr, M));
    }

    private long solution(long[] arr, int m) {
        long answer = 0;
        long lt = 1, rt = Arrays.stream(arr).max().getAsLong();

        while (lt <= rt) {
            long mid = (lt + rt) / 2;
            if (getHeight(arr, mid) >= m) {
                answer = mid;
                lt = mid + 1;
            } else rt = mid - 1;
        }

        return answer;
    }

    private long getHeight(long[] arr, long mid) {
        long sum = 0;
        for(long height : arr){
            if(height>mid) sum += (height-mid);
        }
        return sum;
    }
}
