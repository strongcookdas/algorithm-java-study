package algorithm.bfs.inflearn;

import java.util.*;
public class Tree최단경로 {
    static Node root;

    public static int BFS(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i = 0; i<len; i++){
                Node cur = Q.poll();
                if(cur.lt==null&&cur.rt==null) return L;
                if(cur.lt!=null) Q.offer(cur.lt);
                if(cur.rt!=null) Q.offer(cur.rt);
            }
            L++;
        }
        return L;
    }

    public static void main(String[] args) {
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        System.out.println(BFS(root));
    }
}
