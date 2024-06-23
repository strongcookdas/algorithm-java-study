package algorithm.graph.boj;

import java.io.*;
import java.util.*;

public class 최단경로1753 {
    static class Edge implements Comparable<Edge> {
        int v;
        int c;

        public Edge(int v, int c) {
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(Edge o) {
            return this.c - o.c;
        }
    }

    ArrayList<ArrayList<Edge>> graph;
    int[] dis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        최단경로1753 main = new 최단경로1753();
        main.dis = new int[V + 1];
        main.graph = new ArrayList<>();
        Arrays.fill(main.dis, Integer.MAX_VALUE);
        for (int i = 0; i <= V; i++) {
            main.graph.add(new ArrayList<>());
        }

        int s = Integer.parseInt(br.readLine());
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            main.graph.get(v).add(new Edge(d, c));
        }

        main.solution(s);
        for (int i = 1; i <= V; i++) {
            if (i == s) {
                bw.write(0 + "\n");
            } else if (main.dis[i] == Integer.MAX_VALUE) {
                bw.write("INF\n");
            } else {
                bw.write(main.dis[i] + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private void solution(int s) {
        PriorityQueue<Edge> q = new PriorityQueue<>();
        dis[s] = 0;
        q.offer(new Edge(s, 0));
        while (!q.isEmpty()) {
            Edge tmp = q.poll();
            int now = tmp.v;
            int nowCost = tmp.c;
            if (nowCost > dis[now]) {
                continue;
            }
            for (Edge e : graph.get(now)) {
                if (nowCost + e.c < dis[e.v]) {
                    dis[e.v] = nowCost + e.c;
                    q.offer(new Edge(e.v, dis[e.v]));
                }
            }
        }
    }
}
