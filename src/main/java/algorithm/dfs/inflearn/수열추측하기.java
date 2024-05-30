package algorithm.dfs.inflearn;

import java.util.Scanner;

/*
- 이항 계수에 곱할 수열을 구하는 문제
- N번째의 이항 계수를 구한다.
- DFS를 활용하여 수열을 구하여 이항 계수에 값을 곱해 다음 깊이 탐색으로 넘김
 */
public class 수열추측하기 {
    static int N, F;
    static int[][] arr;
    static int[] bi, pm, ch;
    static boolean flag = false;

    public static int dfsCombi(int n, int r) {
        if (n == r || r == 0) return arr[n][r] = 1;
        if (arr[n][r] != 0) return arr[n][r];
        return arr[n][r] = dfsCombi(n - 1, r - 1) + dfsCombi(n - 1, r);
    }

    public static void dfsPm(int L, int sum) {
        if (flag) return;
        if (L == N) {
            if (sum == F) {
                flag = true;
                for (int n : pm) System.out.print(n + " ");
            }
        }
        if (sum > F) return;
        for (int i = 1; i <= N; i++) {
            if (ch[i] == 1) continue;
            pm[L] = i;
            ch[i] = 1;
            dfsPm(L + 1, sum + (bi[L] * i));
            ch[i] = 0;
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        F = kb.nextInt();
        pm = new int[N];
        bi = new int[N];
        ch = new int[N + 1];
        arr = new int[N][N];
        for (int i = 0; i <= N - 1; i++) bi[i] = dfsCombi(N - 1, i);
        dfsPm(0, 0);
    }
}
