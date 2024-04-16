package algorithm.dfs.inflearn;

import java.util.*;

public class 순열구하기 {
    static int n;
    static int m;
    static int[] pm, ch, arr;

    public static void DFS(int L) {
        if (L == m) {
            for (int i : pm) System.out.print(i + " ");
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (ch[i] != 0) continue;
            pm[L] = arr[i];
            ch[i] = 1;
            DFS(L + 1);
            ch[i] = 0;
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = kb.nextInt();
        ch = new int[n];
        pm = new int[m];
        DFS(0);
    }
}
