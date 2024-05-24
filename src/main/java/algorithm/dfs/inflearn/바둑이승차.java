package algorithm.dfs.inflearn;

import java.util.*;
/*
- DFS 활용
- 종료 조건
    - 트럭 제한 무게 넘어갈 때
 */

public class 바둑이승차 {
    static int C, N, answer = Integer.MIN_VALUE;
    static int[] arr;

    public static void DFS(int L, int sum) {
        if (sum > C) return;
        if (L == N) answer = Math.max(answer, sum);
        else {
            DFS(L + 1, sum + arr[L]);
            DFS(L + 1, sum);
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        C = kb.nextInt();
        N = kb.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = kb.nextInt();
        DFS(0, 0);
        System.out.println(answer);
    }
}
