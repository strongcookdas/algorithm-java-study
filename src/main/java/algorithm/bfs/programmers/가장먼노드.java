package algorithm.bfs.programmers;

import java.util.*;

public class 가장먼노드 {
    int max = Integer.MIN_VALUE, answer = 0;
    int[] ch;
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public void BFS(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        while (!q.isEmpty()) {
            int n = q.size();
            answer = 0;
            for (int i = 0; i < n; i++) {
                int tmp = q.poll();
                answer++;
                for (int d : graph.get(tmp)) {
                    if (ch[d] == 0) {
                        ch[d] = 1;
                        q.offer(d);
                    }
                }
            }
        }
    }

    public int solution(int n, int[][] edge) {
        ch = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : edge) {
            int s = e[0];
            int d = e[1];
            graph.get(s).add(d);
            graph.get(d).add(s);
        }
        ch[1] = 1;
        BFS(1);
        return answer;
    }
}
