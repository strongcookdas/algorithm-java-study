package algorithm.dijkstra.inflearn;

import java.util.*;

public class 다익스트라 {
    static class Edge implements Comparable<Edge> {
        int node;
        int cost;

        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int N, M;
    static int[] dis;
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();
        dis = new int[N + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int s = kb.nextInt();
            int d = kb.nextInt();
            int c = kb.nextInt();
            graph.get(s).add(new Edge(d, c));
        }

        ArrayList<Integer> answer = solution();
        for (int i = 2; i <= N; i++) {
            if (answer.get(i) == Integer.MAX_VALUE) {
                System.out.println(i + " : impossible");
                continue;
            }
            System.out.println(i + " : " + answer.get(i));
        }

    }

    private static ArrayList<Integer> solution() {
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        dis[1] = 0;
        pQ.offer(new Edge(1, 0));
        while (!pQ.isEmpty()) {
            Edge tmp = pQ.poll();
            int now = tmp.node;
            int nowCost = tmp.cost;
            if (nowCost > dis[now]) {
                continue;
            }
            for (Edge e : graph.get(now)) {
                if (nowCost + e.cost < dis[e.node]) {
                    dis[e.node] = nowCost + e.cost;
                    pQ.offer(new Edge(e.node, dis[e.node]));
                }
            }
        }
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i : dis) {
            answer.add(i);
        }
        return answer;
    }
}
