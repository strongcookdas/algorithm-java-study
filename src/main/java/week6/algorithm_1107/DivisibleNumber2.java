package week6.algorithm_1107;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DivisibleNumber2 {
    public int[] solution(int[] arr, int divisor) {
        PriorityQueue<Integer> p = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) p.add(arr[i]);
        }

        if (p.size() == 0) return new int[]{-1};

        int[] answer = new int[p.size()];
        int idx = 0;
        while (!p.isEmpty()) {
            answer[idx++] = p.poll();
        }
        return answer;
    }

    public static void main(String[] args) {
        DivisibleNumber2 d = new DivisibleNumber2();
        int[] arr = {5, 9, 7, 10};
        int divisor = 5;
        System.out.println(Arrays.toString(d.solution(arr, divisor)));
    }
}
