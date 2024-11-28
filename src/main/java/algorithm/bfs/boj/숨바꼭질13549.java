package algorithm.bfs.boj;

//https://www.acmicpc.net/problem/13549

import java.util.*;

public class 숨바꼭질13549 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        숨바꼭질13549 main = new 숨바꼭질13549();
        System.out.println(main.solution(n, k));
    }

    public int solution(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        int[] time = new int[100005];
        Arrays.fill(time, -1);
        q.offer(n);
        time[n] = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int now = q.poll();
                if (now == k) {
                    return time[now];
                }
                if (now * 2 >= 0 && now * 2 < time.length && time[now * 2] == -1) {
                    time[now * 2] = time[now];
                    q.offer(now * 2);
                }
                if (now - 1 >= 0 && now - 1 < time.length && time[now - 1] == -1) {
                    time[now - 1] = time[now] + 1;
                    q.offer(now - 1);
                }
                if (now + 1 >= 0 && now + 1 < time.length && time[now + 1] == -1) {
                    time[now + 1] = time[now] + 1;
                    q.offer(now + 1);
                }
            }
        }
        return -1;
    }

}
