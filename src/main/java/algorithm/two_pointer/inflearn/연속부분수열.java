package algorithm.two_pointer.inflearn;

/*
- 투 포인터, 슬라이딩 윈도우 사용
- 과정
    - 타겟 숫자보다 작을 경우 윈도우를 1칸 늘린다.
    - 타겟 숫자보다 클 경우 윈도우를 1칸 줄인다.
 */
import java.util.*;
public class 연속부분수열 {
    public int solution(int N, int M, int[] arr){
        int answer = 0, lt = 0, sum = 0;
        for (int rt = 0; rt < N; rt++) {
            if(sum < M) sum += arr[rt];
            if(sum == M) answer++;
            while(sum >= M) {
                sum -= arr[lt++];
                if(sum == M) answer ++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        연속부분수열 main = new 연속부분수열();
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int M = kb.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i<N; i++) arr[i] = kb.nextInt();
        System.out.print(main.solution(N,M,arr));
    }
}
