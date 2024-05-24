package algorithm.bfs.inflearn;

import java.util.*;

public class Tree최단경로 {
    static Queue<Node> Q;

    public static int BFS(Node root) {
        int answer = 0;
        Q = new LinkedList<>();
        Q.offer(root);
        while (!Q.isEmpty()) {
            int n = Q.size();
            for (int i = 0; i < n; i++) {
                Node tmp = Q.poll();
                if (tmp.lt == null && tmp.rt == null) return answer;
                if (tmp.lt != null) Q.offer(tmp.lt);
                if (tmp.rt != null) Q.offer(tmp.rt);
            }
            answer++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        System.out.println(BFS(root));
    }
}
