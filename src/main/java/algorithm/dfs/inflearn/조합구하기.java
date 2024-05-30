package algorithm.dfs.inflearn;

import java.util.*;

public class 조합구하기 {
    static int N, M;
    static int[] combi;

    public static void DFS(int L, int n) {
        if (L == M) {
            for(int t : combi) System.out.print(t+" ");
            System.out.println();
            return;
        }
        for(int i = n; i<=N; i++){
            combi[L] = i;
            DFS(L+1, i+1);
        }

    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();
        combi = new int[M];
        DFS(0, 1);
    }
}
