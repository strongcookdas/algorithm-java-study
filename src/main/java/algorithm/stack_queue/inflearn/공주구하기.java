package algorithm.stack_queue.inflearn;

import java.util.*;

public class 공주구하기 {//다시 풀기, 문제 좀 잘 좀 읽자;;;;
    public static int solution(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        int count = 1;
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        while (queue.size() != 1) {
            if (count == k) {
                queue.poll();
                count = 1;
            } else {
                queue.offer(queue.poll());
                count++;
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solution(scanner.nextInt(), scanner.nextInt()));
    }
}
