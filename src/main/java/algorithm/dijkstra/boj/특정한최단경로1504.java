package algorithm.dijkstra.boj;

import java.util.*;
import java.io.*;

// S -> A -> B -> D
// S -> B -> A -> D
public class 특정한최단경로1504 {
    static final int INF = 200000000;

    public static class Node implements Comparable<Node> {
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

    public ArrayList<ArrayList<Node>> graph;

    public 특정한최단경로1504(int N) {
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
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
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        bw.write(main.solution(v1, v2));
        bw.flush();
        bw.close();
        br.close();
    }

    public String solution(int v1, int v2) {
        int[] disFromSource = getDistance(1);
        int[] disFromV1 = getDistance(v1);
        int[] disFromV2 = getDistance(v2);

        int path1 = disFromSource[v1] + disFromV1[v2] + disFromV2[graph.size() - 1];
        int path2 = disFromSource[v2] + disFromV2[v1] + disFromV1[graph.size() - 1];

        int answer = Math.min(path1, path2);
        if (answer >= INF) {
            return String.valueOf(-1);
        } else {
            return String.valueOf(answer);
        }
    }

    public int[] getDistance(int from) {
        int[] dis = new int[graph.size()];
        Arrays.fill(dis, INF);
        dis[from] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(from, 0));

        while (!pq.isEmpty()) {
            Node tmp = pq.poll();
            int cost = dis[tmp.node];

            if (cost > tmp.cost) {
                continue;
            }

            for (Node d : graph.get(tmp.node)) {
                int dCost = cost + d.cost;
                if (dis[d.node] > dCost) {
                    dis[d.node] = dCost;
                    pq.add(new Node(d.node, dis[d.node]));
                }
            }
        }

        return dis;
    }
}
