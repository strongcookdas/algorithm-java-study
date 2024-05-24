package algorithm.dfs.inflearn;

public class Tree최단경로 {
    static Node root;

    public static int DFS(int L, Node node) {
        if (node.lt == null && node.rt == null) return L;
        return Math.min(DFS(L + 1, node.lt), DFS(L + 1, node.rt));
    }

    public static void main(String[] args) {
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        System.out.println(DFS(0, root));
    }

}
