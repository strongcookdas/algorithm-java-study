package algorithm.dfs.inflearn;

/*
- DFS 활용
    - 중복 순열 구하는 방식 활용
    - 단, visit 배열 추가하여 해당 원소 추가했는지 확인하는 로직 추가
- 종료 조건
    - L == M
 */

import java.util.*;

public class 순열구하기 {
    static int N, M;
    static int[] arr, visit, pm;

    public static void DFS(int L) {
        if (L == M) {
            for (int n : pm) System.out.print(n + " ");
            System.out.println();
        }else{
            for(int i = 0; i<N; i++){
                if(visit[i]==0){
                    visit[i] = 1;
                    pm[L] = arr[i];
                    DFS(L+1);
                    visit[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();
        arr = new int[N];
        visit = new int[N];
        pm = new int[M];
        for (int i = 0; i < N; i++) arr[i] = kb.nextInt();
        DFS(0);
    }
}
