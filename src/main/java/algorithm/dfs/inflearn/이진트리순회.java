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
    public static void DFS1(Node node) {//전위순회
        if (node == null) return;
        System.out.print(node.data + " ");
        DFS1(node.lt);
        DFS1(node.rt);
    }

    public static void DFS2(Node node) {//중위 순회
        if (node == null) return;
        DFS2(node.lt);
        System.out.print(node.data + " ");
        DFS2(node.rt);
    }

    public static void DFS3(Node node) {
        if (node == null) return;
        DFS3(node.lt);
        DFS3(node.rt);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        System.out.print("전위순회 출력 : ");
        DFS1(root);
        System.out.println();
        System.out.print("중위순회 출력 : ");
        DFS2(root);
        System.out.println();
        System.out.print("후위순회 출력 : ");
        DFS3(root);
    }
}
