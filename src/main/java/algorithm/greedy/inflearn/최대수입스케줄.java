package algorithm.greedy.inflearn;

// 기준일을 기준으로 내림차순 정렬
// Priority 큐 사용

import java.util.*;

public class 최대수입스케줄 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int[][] arr = new int[N][2];
        int days = -1;
        for (int i = 0; i < N; i++) {
            arr[i][0] = kb.nextInt();
            arr[i][1] = kb.nextInt();
            days = Math.max(days, arr[i][1]);
        }

        최대수입스케줄 main = new 최대수입스케줄();
        System.out.println(main.solution(arr, days));
    }

    private int solution(int[][] arr, int days) {
        Arrays.sort(arr, (a, b) -> b[1] - a[1]);

        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        int idx = 0;
        int answer = 0;
        for (int i = days; i >= 1; i--) {
            while (idx < arr.length && arr[idx][1] == i) {
                q.offer(arr[idx++][0]);
            }
            if (!q.isEmpty()) {
                answer += q.poll();
            }
        }
        return answer;
    }
}
