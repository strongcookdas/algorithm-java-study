package algorithm.dfs.inflearn;
/*
- 순열과 달리 n에 대하여 깊이 탐색 후 완료 시 ch 배열에 체크를 해제 하지 않는다.
 */

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
