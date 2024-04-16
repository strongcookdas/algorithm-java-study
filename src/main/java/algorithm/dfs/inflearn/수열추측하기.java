package algorithm.dfs.inflearn;

import java.util.*;

public class 수열추측하기 {
    static int n, f;
    static int[][] dy = new int[35][35];
    static int[] bc, pm, ch;
    static boolean flag = false;

    public static int combi(int n, int r) {
        if (dy[n][r] > 0) return dy[n][r];
        if (n == r || r == 0) return 1;
        return combi(n - 1, r) + combi(n - 1, r - 1);
    }

    public static void DFS(int L, int sum) {
        if (flag) return;
        if (L == n) {
            if (sum == f) {
                for (int x : pm) System.out.print(x + " ");
                flag = true;
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pm[L] = i;
                    DFS(L + 1, sum + (pm[L] * bc[L]));
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        f = kb.nextInt();
        bc = new int[n];
        pm = new int[n];
        ch = new int[n + 1];
        for (int i = 0; i < n; i++) {
            bc[i] = combi(n - 1, i);
        }
        DFS(0, 0);
    }
}
