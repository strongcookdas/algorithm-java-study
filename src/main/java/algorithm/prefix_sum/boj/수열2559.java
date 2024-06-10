package algorithm.prefix_sum.boj;

import java.util.*;

public class 수열2559 {
    public int solution(int K, int[] arr) {
        int lt = 0;
        int max = Integer.MIN_VALUE;
        for (int rt = K; rt < arr.length; rt++) {
            max = Math.max(max, arr[rt] - arr[lt]);
            lt++;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int K = kb.nextInt();
        kb.nextLine();
        String[] inputs = kb.nextLine().split(" ");

        int[] prefixSum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i - 1] + Integer.parseInt(inputs[i - 1]);
        }

        수열2559 main = new 수열2559();
        System.out.println(main.solution(K, prefixSum));
    }
}
