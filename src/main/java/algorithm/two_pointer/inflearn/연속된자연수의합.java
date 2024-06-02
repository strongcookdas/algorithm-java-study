package algorithm.two_pointer.inflearn;

import java.util.*;
public class 연속된자연수의합 {
    public int solution(int N){
        int lt = 1, sum = 0, answer = 0;
        for(int rt = 1; rt<=(N/2)+N%2; rt++){
            if(sum < N) sum += rt;
            if(sum==N) answer++;
            while(sum >= N){
                sum -= lt++;
                if(sum == N) answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        연속된자연수의합 main = new 연속된자연수의합();
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        System.out.println(main.solution(N));
    }
}
