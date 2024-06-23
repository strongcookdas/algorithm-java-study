package algorithm.graph.inflearn;

import java.util.Scanner;

public class 친구인가 {
    static int[] unf;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int M = kb.nextInt();
        unf = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            unf[i] = i;
        }
        for (int i = 0; i < M; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            union(a, b);
        }
        int a = find(kb.nextInt());
        int b = find(kb.nextInt());
        if (a == b) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    static public void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            unf[fa] = fb;
        }
    }

    static public int find(int a) {
        if (unf[a] == a) {
            return a;
        }
        return unf[a] = find(unf[a]);
    }
}
