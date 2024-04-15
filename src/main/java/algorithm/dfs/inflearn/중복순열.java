package algorithm.dfs.inflearn;
/*
- 중복 순열 N개에서 M개를 중복을 허용하여 선택하고 나열
- DFS 사용
- 한 노드에서 모든 노드를 호출한다.
- 종료 기준
    - L이 m일 경우
 */

import java.util.*;

public class 중복순열 {
    static int n;
    static int m;
    static int[] arr;

    public static void DFS(int L) {
        if (L == m) {
            for (int i : arr) System.out.print(i + " ");
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            arr[L] = i;
            DFS(L + 1);
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        arr = new int[m];
        DFS(0);
    }
}
