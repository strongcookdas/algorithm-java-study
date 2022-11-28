package algorithm.problem;

import java.util.Arrays;

public class Budget {
    //프로그래머스 이분탐색 문제 예산
    public int solution(int[] d, int budget) {
        int answer = 0;
        int sum = 0;
        Arrays.sort(d);
        System.out.println(Arrays.toString(d));
        for (int i = 0; i < d.length; i++) {
            sum += d[i];
            if (sum > budget) break;
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Budget().solution(new int[]{2, 2, 3, 3}, 10));
    }
}
