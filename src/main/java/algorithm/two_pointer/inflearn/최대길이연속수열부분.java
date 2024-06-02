package algorithm.two_pointer.inflearn;


/*
- 과정
    - 1일 경우 슬라이딩 윈도우 증가
    - 0일 경우
        - k > 0 슬라이딩 윈도우 증가
        - k < 0 첫번째 0 위치 다음으로 lt 조정 후 슬라이딩 윈도우 증가
 */

import java.util.Scanner;

public class 최대길이연속수열부분 {
    public int solution(int N, int K, int[] arr) {
        int lt = 0, answer = Integer.MIN_VALUE;
        for (int rt = 0; rt < N; rt++) {
            if (arr[rt] == 0) {
                if (K > 0) K--;
                else {
                    while (arr[lt] != 0) lt++;
                    lt++;
                }
            }
            answer = Math.max(answer, rt - lt + 1);
        }
        return answer;
    }

    public static void main(String[] args) {
        최대길이연속수열부분 main = new 최대길이연속수열부분();
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int K = kb.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = kb.nextInt();
        System.out.println(main.solution(N, K, arr));
    }
}
