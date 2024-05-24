package algorithm.dfs.inflearn;

import java.util.*;

/*
- DFS 부분집합 구하는 방식을 활용
- 1개의 부분 집합이 구해지면 총 합에서 부분 집합의 합을 빼 비교.
    - 같으면 YES
    - 다르면 NO
- 합이 총 합의 절반보다 높으면 return
 */
public class 합이같은부분집합 {
    static int N, total = 0;
    static boolean flag = false;
    static int[] arr;

    public static void DFS(int L, int sum) {
        if (flag) return;
        if (sum > total / 2) return;
        if (L == N) {
            if (sum == total - sum) flag = true;
        } else {
            DFS(L + 1, sum + arr[L]);
            DFS(L + 1, sum);
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = kb.nextInt();
            total += arr[i];
        }
        DFS(0, 0);
        System.out.println((flag) ? "YES" : "NO");
    }
}
