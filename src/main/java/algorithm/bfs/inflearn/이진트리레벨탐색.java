package algorithm.bfs.inflearn;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node lt, rt;

    public Node(int value) {
        this.data = value;
        lt = rt = null;
    }
}

public class 이진트리레벨탐색 {
    public static void BFS(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        int L = 1;
        while (!q.isEmpty()) {
            int n = q.size();
            System.out.print(L++ + " : ");
            for (int i = 0; i < n; i++) {
                Node tmp = q.poll();
                System.out.print(tmp.data + " ");
                if (tmp.lt != null) q.offer(tmp.lt);
                if (tmp.rt != null) q.offer(tmp.rt);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        BFS(root);
    }
}
