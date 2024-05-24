package algorithm.dfs.inflearn;
/*
- DFS 활용
    - 중복 순열 구하는 방식 활용
- 종료 조건
    - 합이 넘어갈 때
    - 최소 개수가 넘어갈 때
    - 합이 거슬러 줄 금액과 같을 때
        - 비교
- 시간 초과
    - 원소가 많을 경우
    - 내림차순으로 정렬해야 시간 초과가 발생 x
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 동전교환 {
    static int N, M, answer = Integer.MAX_VALUE;
    static Integer[] arr;

    public static void DFS(int L, int sum) {
        if (sum > M) return;
        if (L > answer) return;
        if (sum == M) answer = Math.min(answer, L);
        else for (int i = 0; i < N; i++) DFS(L + 1, sum + arr[i]);
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        arr = new Integer[N];
        for (int i = 0; i < N; i++) arr[i] = kb.nextInt();
        Arrays.sort(arr, Collections.reverseOrder());
        M = kb.nextInt();
        DFS(0, 0);
        System.out.println(answer);
    }
}
