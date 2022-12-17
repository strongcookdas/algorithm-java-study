package algorithm.Like_lion.week9.algorithm_1201;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HallOfFame {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int idx = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < score.length; i++) {
            if (i < k) pq.add(score[i]);
            else {
                if (pq.peek() < score[i]) {
                    pq.poll();
                    pq.add(score[i]);
                }
            }
            answer[idx++] = pq.peek();
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] ans = new HallOfFame().solution(3, new int[]{10, 100, 20, 150, 1, 100, 200});
        System.out.println(Arrays.toString(ans));
    }
}
