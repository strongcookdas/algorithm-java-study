package algorithm.dfs.inflearn;
/*
- DFS 문제 (BFS 적용 가능할 거 같기도)
- 중복 순열 문제처럼 푼다.
- DFS 함수 종료 조건
    - L이 MIN 값보다 클때
    - 거슬러 줄 금액보다 총 금액이 초과될 때

- 시간 초과 난 이유
    - 단위가 작은 동전부터 탐색했기 때문에 탐색 횟수가 많아짐
    - 단위가 큰 동전부터 탐색
 */

import java.util.*;
public class 동전교환 {
    static int n;
    static Integer[] arr;
    static int min = Integer.MAX_VALUE;
    static int m;
    public static void DFS(int L, int total){
        if(total>m) return;
        if(L>=min) return;
        if(total == m) {
            min = Math.min(min, L);
        }else{
            for(int i = 0; i<n; i++){
                DFS(L+1, total+arr[i]);
            }
        }
    }

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        arr = new Integer[n];
        for(int i = 0; i<n; i++) arr[i] = kb.nextInt();
        Arrays.sort(arr,Collections.reverseOrder());
        m = kb.nextInt();
        DFS(0,0);
        System.out.println(min);
    }
}
