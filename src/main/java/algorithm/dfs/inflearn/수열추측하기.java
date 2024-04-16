package algorithm.dfs.inflearn;

import java.util.*;

public class 수열추측하기 {
    static int n;
    static int f;
    static int[][] ch = new int[12][12];
    static int[] bc, pm, visit;
    static boolean flag = false;

    public static int combination(int n, int r) {
        if (ch[n][r] > 0) return ch[n][r];
        if (n == r || r == 0) return 1;
        return combination(n - 1, r) + combination(n - 1, r - 1);
    }

    public static void DFS(int L) {
        if (flag) return;
        if (L == n) {
            int sum = 0;
            for (int i = 0; i < n; i++) sum += (pm[i] * bc[i]);
            if (sum == f) flag = true;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (visit[i] != 0) continue;
            if (flag) continue;
            pm[L] = i;
            visit[i] = 1;
            DFS(L + 1);
            visit[i] = 0;
        }
    }

    public static void solution() {
        for (int i = 0; i < n; i++) {
            bc[i] = combination(n - 1, i);
        }
        DFS(0);
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        f = kb.nextInt();
        bc = new int[n];
        pm = new int[n];
        visit = new int[n + 1];
        solution();
        for (int i : pm) System.out.print(i + " ");
    }
}
