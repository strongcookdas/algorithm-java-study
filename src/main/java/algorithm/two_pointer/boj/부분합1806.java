package algorithm.two_pointer.boj;

/*
- 투포인터 사용
- 과정
    - 부분합이 S보다 작으면 rt 전진하면서 +
    - 부분합이 S보다 크면 최소값 갱신 후 lt 전진하면서 -
    - 부분합이 1개일 때도 가능
 - 제출 5번 원인
    - 부분합이 S와 같을 때가 아니라 S이상 일 때 최소값을 구하는 것
    - 문제를 잘 읽자
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분합1806 {
    int N, S;
    int[] arr;
    public int solution() {
        int answer = Integer.MAX_VALUE;
        int sum = 0, lt = 0;
        for (int rt = 0; rt < arr.length; rt++) {
            if (sum < S) sum += arr[rt];
            while (sum >= S) {
                answer = Math.min(answer, rt - lt + 1);
                sum -= arr[lt++];
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        부분합1806 main = new 부분합1806();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        main.N = Integer.parseInt(st.nextToken());
        main.S = Integer.parseInt(st.nextToken());
        main.arr = new int[main.N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < main.N; i++) {
            main.arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = main.solution();
        System.out.print((answer == Integer.MAX_VALUE) ? 0 : answer);
    }
}
