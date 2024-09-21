package algorithm.tree.boj;

import java.util.*;
import java.io.*;

public class 트리의높이와너비2250 {
    static class Node {
        int num;
        int parent;
        int left;
        int right;

        public Node(int num, int left, int right) {
            this.num = num;
            this.parent = -1;
            this.left = left;
            this.right = right;
        }
    }

    Node[] tree;
    int[][] minMax;
    int idx = 1;

    public 트리의높이와너비2250(int N) {
        tree = new Node[N + 1];
        minMax = new int[N + 1][2];
        for (int i = 0; i <= N; i++) {
            tree[i] = new Node(i, -1, -1);
            minMax[i][0] = N;
            minMax[i][1] = 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        트리의높이와너비2250 main = new 트리의높이와너비2250(N);
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int root = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            main.tree[root].left = left;
            main.tree[root].right = right;

            if (left != -1) {
                main.tree[left].parent = root;
            }
            if (right != -1) {
                main.tree[right].parent = root;
            }
        }

        int root = 0;
        for (int i = 1; i <= N; i++) {
            if (main.tree[i].parent == -1) {
                root = i;
                break;
            }
        }

        main.inOrder(1, root);

        int level = 1;
        int width = 0;
        for (int i = 1; i <= N; i++) {
            int tmp = main.minMax[i][1] - main.minMax[i][0] + 1;
            if (tmp > width) {
                width = tmp;
                level = i;
            }
        }

        System.out.println(level + " " + width);
    }

    private void inOrder(int L, int root) {
        if (root == -1) {
            return;
        }
        inOrder(L + 1, this.tree[root].left);
        this.minMax[L][0] = Math.min(this.minMax[L][0], this.idx);
        this.minMax[L][1] = Math.max(this.minMax[L][1], this.idx);
        this.idx++;
        inOrder(L + 1, this.tree[root].right);
    }
}