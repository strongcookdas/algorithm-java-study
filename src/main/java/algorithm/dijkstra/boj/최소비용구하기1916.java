package algorithm.dijkstra.boj;

import java.util.*;
import java.io.*;

public class 최소비용구하기1916 {
    int[] dis;
    ArrayList<ArrayList<Edge>> graph;

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        최소비용구하기1916 main = new 최소비용구하기1916();
        int N = Integer.parseInt(br.readLine());
        main.dis = new int[N + 1];
        main.graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            main.graph.add(new ArrayList<>());
        }

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            main.graph.get(start).add(new Edge(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        bw.write(String.valueOf(main.solution(start, end)));
        bw.flush();
        bw.close();
        br.close();
    }

    private int solution(int start, int end) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[start] = 0;
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge tmp = pq.poll();
            int cost = dis[tmp.node];
            if (tmp.cost > cost) {
                continue;
            }
            if (tmp.node == end) {
                return cost;
            }
            for (Edge e : graph.get(tmp.node)) {
                int eCost = cost + e.cost;
                if (dis[e.node] > eCost) {
                    dis[e.node] = eCost;
                    pq.add(new Edge(e.node, dis[e.node]));
                }
            }
        }
        return 0;
    }
}
