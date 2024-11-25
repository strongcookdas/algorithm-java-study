package algorithm.dijkstra.boj;

import java.util.*;
import java.io.*;

public class 특정한최단경로1504 {
    static class Node implements Comparable<Node> {
        int node;
        int cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    ArrayList<ArrayList<Node>> graph;
    int[] dis;

    public 특정한최단경로1504(int N) {
        this.dis = new int[N + 1];
        this.graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            this.graph.add(new ArrayList<>());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        특정한최단경로1504 main = new 특정한최단경로1504(N);
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            main.graph.get(s).add(new Node(d, c));
            main.graph.get(d).add(new Node(s, c));
        }

        st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        System.out.println(main.solution(N, n1, n2));
    }

    public int solution(int n, int n1, int n2) {
        int p1 = getDis(1, n1);
        int p2 = getDis(n1, n2);
        int p3 = getDis(n2, n);

        int p4 = getDis(1, n2);
        int p5 = getDis(n2, n1);
        int p6 = getDis(n1, n);

        int dis1, dis2;
        if (p1 == -1 || p2 == -1 || p3 == -1) {
            dis1 = -1;
        } else {
            dis1 = p1 + p2 + p3;
        }

        if (p3 == -1 || p4 == -1 || p5 == -1) {
            dis2 = -1;
        } else {
            dis2 = p4 + p5 + p6;
        }

        if (dis1 == -1) {
            return dis2;
        } else if (dis2 == -1) {
            return dis1;
        }

        return Math.min(dis1, dis2);
    }

    public int getDis(int s, int d) {
        Arrays.fill(this.dis, Integer.MAX_VALUE);
        this.dis[s] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(s, 0));
        while (!pq.isEmpty()) {
            Node tmp = pq.poll();
            int now = tmp.node;
            int nowCost = tmp.cost;
            if (now == d) {
                return nowCost;
            }
            if (this.dis[now] < nowCost) {
                continue;
            }
            for (Node node : this.graph.get(now)) {
                if (dis[node.node] > nowCost + node.cost) {
                    dis[node.node] = nowCost + node.cost;
                    pq.offer(new Node(node.node, dis[node.node]));
                }
            }
        }
        return -1;
    }
}
