package algorithm.dfs.inflearn;

import java.util.*;

public class 바둑이승차 {
    static int c, n, max = Integer.MIN_VALUE;

    public static void dfs(int L, int sum, int[] arr) {
        if (sum > c) return;
        if (L == n) max = Math.max(max, sum);
        else {
            dfs(L + 1, sum + arr[L], arr);
            dfs(L + 1, sum, arr);
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        c = kb.nextInt();
        n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = kb.nextInt();
        dfs(0,0,arr);
        System.out.println(max);
    }
}
