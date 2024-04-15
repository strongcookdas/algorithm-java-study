package algorithm.dfs.inflearn;

/*
- DFS 적용
- 문제 클래스 생성
- DFS
    - 매개 변수
        - 문제 배열
        - 점수의 합
        - 시간의 합
        - Level
- 모든 문제의 조합을 탐색
    - 정해진 시간이 초과시 return
    - 점수의 Max값을 구함
- 걸린 시간
    - 15분
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
    static Problem[] arr;
    static int n;
    static int timeLimit;
    static int max = Integer.MIN_VALUE;

    public static void DFS(int L, int sum, int time, Problem[] arr) {
        if (time > timeLimit) return;
        if (L == n) max = Math.max(max, sum);
        else {
            DFS(L + 1, sum + arr[L].score, time + arr[L].time, arr);
            DFS(L + 1, sum, time, arr);
        }
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        arr = new Problem[n];
        timeLimit = kb.nextInt();
        for (int i = 0; i < n; i++) arr[i] = new Problem(kb.nextInt(), kb.nextInt());
        DFS(0,0,0,arr);
        System.out.println(max);
    }
}
