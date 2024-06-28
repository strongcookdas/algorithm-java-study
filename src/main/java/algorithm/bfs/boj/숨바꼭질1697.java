package algorithm.bfs.boj;

import java.util.*;

public class 숨바꼭질1697 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int K = kb.nextInt();

        숨바꼭질1697 main = new 숨바꼭질1697();
        System.out.println(main.bfs(N, K));
    }

    private int bfs(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        q.offer(n);
        visited.add(n);
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int x = q.poll();
                if (x == k) {
                    return count;
                }
                int[] position = {x + 1, x - 1, x * 2};
                for (int p : position) {
                    if (!visited.contains(p) && p >= 0 && p <= 100000) {
                        visited.add(p);
                        q.offer(p);
                    }
                }
            }
            count++;
        }
        return count;
    }
}
