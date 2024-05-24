package algorithm.dfs.inflearn;

/*
- DFS 활용
- 종료 조건
    - L == N
    - 제한 시간이 넘어갈 때
 */

import java.util.*;

class Problem {
    int score;
    int time;

    public Problem(int score, int time) {
        this.score = score;
        this.time = time;
    }
}

public class 최대점수구하기 {
    static int N,M, answer = Integer.MIN_VALUE;
    static Problem[] arr;
    public static void DFS(int L, int sum, int time){
        if(time > M) return;
        if(L==N) answer = Math.max(sum, answer);
        else{
            DFS(L+1, sum+arr[L].score, time+arr[L].time);
            DFS(L+1, sum, time);
        }
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();
        arr = new Problem[N];
        for(int i = 0; i<N; i++) arr[i] = new Problem(kb.nextInt(), kb.nextInt());
        DFS(0,0,0);
        System.out.println(answer);
    }
}
