package algorithm.tree.boj;

import java.io.*;

public class 트리순회1991 {
    static class Tree {
        private Node root;

        public void addNode(char parent, char leftChild, char rightChild) {
            if (root == null) {
                root = new Node(parent);
            }
            addNode(root, parent, leftChild, rightChild);
        }

        private void addNode(Node current, char parent, char leftChild, char rightChild) {
            if (current == null) {
                return;
            }
            if (current.data == parent) {
                if (leftChild != '.') {
                    current.left = new Node(leftChild);
                }
                if (rightChild != '.') {
                    current.right = new Node(rightChild);
                }
            } else {
                addNode(current.left, parent, leftChild, rightChild);
                addNode(current.right, parent, leftChild, rightChild);
            }
        }
    }

    static class Node {
        char data;
        Node left;
        Node right;

        public Node(char data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Tree tree = new Tree();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            char parent = input[0].charAt(0);
            char leftChild = input[1].charAt(0);
            char rightChild = input[2].charAt(0);

            tree.addNode(parent, leftChild, rightChild);
        }

        트리순회1991 main = new 트리순회1991();
        main.preOrder(tree.root);
        System.out.println();
        main.inOrder(tree.root);
        System.out.println();
        main.postOrder(tree.root);
        System.out.println();
    }

    private void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data);
    }

    private void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data);
        inOrder(root.right);
    }

    private void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }
}
