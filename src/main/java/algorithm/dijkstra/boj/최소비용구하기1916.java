package algorithm.dijkstra.boj;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1916
public class 최소비용구하기1916 {

    static class Node implements Comparable<Node> {
        int node;
        int dis;

        public Node(int d, int c) {
            this.node = d;
            this.dis = c;
        }

        @Override
        public int compareTo(Node o) {
            return this.dis - o.dis;
        }
    }

    PriorityQueue<Node> pq = new PriorityQueue<>();
    ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    int[] ch;
    int[] dis;

    public 최소비용구하기1916(int n) {
        ch = new int[n + 1];
        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        최소비용구하기1916 main = new 최소비용구하기1916(N);
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            main.graph.get(s).add(new Node(d, c));
        }
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        System.out.println(main.solution(s, d));

    }

    private int solution(int s, int d) {
        ch[s] = 1;
        dis[s] = 0;
        pq.offer(new Node(s, dis[s]));
        while (!pq.isEmpty()) {
            Node tmp = pq.poll();
            int now = tmp.node;
            int nowCost = tmp.dis;
            if (tmp.node == d) {
                return dis[tmp.node];
            }
            if (nowCost > dis[now]) {
                continue;
            }
            for (Node n : graph.get(now)) {
                if (nowCost + n.dis < dis[n.node]) {
                    dis[n.node] = nowCost + n.dis;
                    pq.offer(new Node(n.node, dis[n.node]));
                }
            }
        }
        return -1;
    }
}
