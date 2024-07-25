package algorithm.bfs.boj;

import java.util.*;

public class 숨바꼭질13549 {
    static class Position {
        int x;
        int time;

        public Position(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int K = kb.nextInt();

        숨바꼭질13549 main = new 숨바꼭질13549();
        System.out.println(main.solution(N, K));
    }

    private int solution(int n, int k) {
        Queue<Position> q = new LinkedList<>();
        HashMap<Integer, Integer> visited = new HashMap<>();
        q.offer(new Position(n, 0));
        visited.put(n, 0);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Position p = q.poll();
                if (p.x == k) {
                    return p.time;
                }
                int[] move = {p.x * 2, p.x - 1, p.x + 1};
                int[] time = {p.time, p.time + 1, p.time + 1};
                for (int j = 0; j < move.length; j++) {
                    int nx = move[j];
                    int nTime = time[j];
                    if (nx >= 0 && nx <= 100000 && (!visited.containsKey(nx) || visited.get(nx) > nTime)) {
                        visited.put(nx, nTime);
                        q.offer(new Position(nx, nTime));
                    }
                }
            }
        }
        return 0;
    }
}
