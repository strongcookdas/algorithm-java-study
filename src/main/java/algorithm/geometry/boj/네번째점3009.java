package algorithm.geometry.boj;

import java.util.*;

public class 네번째점3009 {
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        Node[] arr = new Node[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = new Node(-1, -1);
            arr[i].x = kb.nextInt();
            arr[i].y = kb.nextInt();
        }

        int x = -1;
        if (arr[0].x == arr[1].x) {
            x = arr[2].x;
        } else if (arr[0].x == arr[2].x) {
            x = arr[1].x;
        } else if (arr[1].x == arr[2].x) {
            x = arr[0].x;
        }

        int y = -1;
        if (arr[0].y == arr[1].y) {
            y = arr[2].y;
        } else if (arr[0].y == arr[2].y) {
            y = arr[1].y;
        } else if (arr[1].y == arr[2].y) {
            y = arr[0].y;
        }

        System.out.println(x + " " + y);
    }
}
