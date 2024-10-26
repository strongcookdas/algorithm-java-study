package algorithm.binary_search.boj;

import java.util.*;
import java.io.*;
import java.util.*;
import java.io.*;

public class 중량제한1939 {
    ArrayList<ArrayList<Node>> graph;
    boolean[] ch;

    static class Node {
        int num;
        int cost;

        public Node(int n, int c) {
            this.num = n;
            this.cost = c;
        }
    }

    public 중량제한1939(int N, int M) {
        this.graph = new ArrayList<>();
        this.ch = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            this.graph.add(new ArrayList<>());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        중량제한1939 main = new 중량제한1939(N, M);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            main.graph.get(s).add(new Node(d, c));
            main.graph.get(d).add(new Node(s, c));
        }

        for (ArrayList<Node> list : main.graph) {
            list.sort((a, b) -> b.cost - a.cost);
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        System.out.println(main.solution(s, d));
        br.close();
    }

    public int solution(int s, int d) {
        int answer = -1;
        int lt = 1, rt = 1_000_000_000;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (validPath(mid, s, d)) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        return answer;
    }

    public boolean validPath(int c, int s, int d) {
        boolean[] ch = new boolean[this.graph.size()];
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        ch[s] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int tmp = q.poll();
                if (tmp == d) {
                    return true;
                }
                for (Node node : this.graph.get(tmp)) {
                    if (node.cost >= c && !ch[node.num]) {
                        ch[node.num] = true;
                        q.offer(node.num);
                    }
                }
            }
        }
        return false;
    }
}
