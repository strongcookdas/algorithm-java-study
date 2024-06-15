package algorithm.prefix_sum.boj;

import java.util.*;

public class 나머지합10986 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int M = kb.nextInt();
        kb.nextLine();
        String[] inputs = kb.nextLine().split(" ");
        long[] prefixSum = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i - 1] + Long.parseLong(inputs[i - 1]);
        }
        나머지합10986 main = new 나머지합10986();
        System.out.println(main.solution(N, M, prefixSum));
    }

    private long solution(int N, int M, long[] prefixSum) {
        long answer = 0;
        long[] rArr = new long[M];

        rArr[0] = 1;

        for (int i = 1; i <= N; i++) {
            int r = (int)(prefixSum[i] % M);
//            System.out.println(r);
//            if (r < 0) r += M;
            answer += rArr[r];
            rArr[r]++;
        }

        return answer;
    }
}
