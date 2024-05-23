package algorithm.dfs.inflearn;

import java.util.*;

/*
부분 집합
- 원소가 있거나 없거나 둘중 하나
    - 원소가 있을 경우 깊이 우선 탐색
    - 없을 경우 깊이 우선 탐색
    - 출력 레벨이 n+1이면
 */

public class 부분집합 {
    static boolean[] visit;
    static int n;

    public static void DFS(int L) {
        if (L == n + 1) {
            String tmp = "";
            for (int i = 1; i <= n; i++) if (visit[i]) tmp += (i + " ");
            if (tmp.length() > 0) System.out.println(tmp);
            return;
        }
        visit[L] = true;
        DFS(L + 1);
        visit[L] = false;
        DFS(L + 1);
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        visit = new boolean[n + 1];
        Arrays.fill(visit, true);
        DFS(1);
    }
}
