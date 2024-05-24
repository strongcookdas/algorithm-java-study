package algorithm.dfs.inflearn;
/*
- 중복 순열 N개에서 M개를 중복을 허용하여 선택하고 나열
- DFS 사용
- 한 노드에서 모든 노드를 호출한다.
- 종료 기준
    - L이 m일 경우
 */

import java.util.Scanner;

public class 중복순열 {
    static int N,M;
    static int[] answer;
    public static void DFS(int L){
        if(L==M) {
            for(int n : answer) {
                System.out.print(n+" ");
            }
            System.out.println();
        }else{
            for(int i = 1; i<=N; i++){
                answer[L] = i;
                DFS(L+1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();
        answer = new int[M];
        DFS(0);
    }
}
