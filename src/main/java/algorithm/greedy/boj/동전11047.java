package algorithm.greedy.boj;

import java.util.*;
public class 동전11047 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int K = kb.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i<N; i++) arr[i] = kb.nextInt();

        동전11047 main = new 동전11047();
        System.out.println(main.solution(arr, K));
    }

    private int solution(int[] arr, int k) {
        int answer = 0;
        for(int i = arr.length-1; i>=0; i--){
            answer += k/arr[i];
            k%=arr[i];
        }
        return answer;
    }
}
