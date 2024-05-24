package algorithm.dfs.inflearn;

/*
- DFS 활용
- nCr = n-1Cr-1 + n-1Cr 공식 사용
    - n==r 일 경우 1
    - r==0 일 경우 1
- 종료 조건
    - N==R 일때 1리턴 N개중 N개를 선택
    - R==0 일때 1리턴 4개중 0개를 선택
    - ch 배열의 값이 0보다 클 경우 반환
 */

import java.util.*;

public class 조합수 {
    static int N, R;
    static int[][] ch;

    public static int DFS(int n, int r) {
        if (n == r || r == 0) return 1;
        if (ch[n][r] > 0) return ch[n][r];
        return ch[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        R = kb.nextInt();
        ch = new int[N+1][N+1];
        System.out.println(DFS(N, R));
    }
}
