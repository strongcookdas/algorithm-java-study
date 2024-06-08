package algorithm.stack_queue.inflearn;

import java.util.*;

public class 공주구하기 {
    public static int solution(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) q.offer(i);
        int cnt = 1;
        while (q.size() > 1) {
            if (cnt == k) {
                q.poll();
                cnt = 1;
            } else {
                q.offer(q.poll());
                cnt++;
            }
        }
        return q.poll();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solution(scanner.nextInt(), scanner.nextInt()));
    }
}
