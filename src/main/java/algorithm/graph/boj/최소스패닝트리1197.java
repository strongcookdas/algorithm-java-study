package algorithm.graph.boj;

import java.util.*;
import java.io.*;

public class 최소스패닝트리1197 {
    static class Node implements Comparable<Node> {
        int v;
        int c;

        public Node(int v, int c) {
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(Node o) {
            return this.c - o.c;
        }
    }

    int[] ch;
    ArrayList<ArrayList<Node>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        최소스패닝트리1197 main = new 최소스패닝트리1197();
        main.graph = new ArrayList<>();
        main.ch = new int[V + 1];
        for (int i = 0; i <= V; i++) {
            main.graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            main.graph.get(a).add(new Node(b, c));
            main.graph.get(b).add(new Node(a, c));
        }

        System.out.println(main.solution());
    }

    private long solution() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        long answer = 0;
        pq.offer(new Node(1, 0));
        while (!pq.isEmpty()) {
            Node tmp = pq.poll();
            if (ch[tmp.v] == 0) {
                answer += tmp.c;
                ch[tmp.v] = 1;
                for (Node n : graph.get(tmp.v)) {
                    if (ch[n.v] == 0) {
                        pq.offer(n);
                    }
                }
            }
        }
        return answer;
    }
}
