package algorithm.dfs.inflearn;

class Node {
    int data;
    Node lt, rt;

    public Node(int value) {
        this.data = value;
        lt = rt = null;
    }
}

public class 이진트리순회 {
    static Node root;

    public static void DFS(Node root) {
        if (root == null) return;
//        System.out.print(root.data+" "); //전위 순회
        DFS(root.lt);
        System.out.print(root.data+" "); //중위 순회
        DFS(root.rt);
//        System.out.print(root.data+" "); //후위 순회
    }

    public static void main(String[] args) {
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        DFS(root);
    }
}
