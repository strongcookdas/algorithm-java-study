package algorithm.dynamic.boj;

import java.util.*;
import java.io.*;

public class 더하기1239095 {
    int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] inputs = new int[N];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, inputs[i]);
        }

        더하기1239095 main = new 더하기1239095();
        main.solution(max, inputs, bw);

        bw.flush();
        bw.close();
        br.close();
    }

    private void solution(int max, int[] inputs, BufferedWriter bw) throws IOException {
        dp = new int[max + 1];
        for (int i = 1; i <= max; i++) {
            if (i == 1) {
                dp[i] = 1;
            } else if (i == 2) {
                dp[i] = 2;
            } else if (i == 3) {
                dp[i] = 4;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
        }

        for (int t : inputs) {
            bw.write(dp[t] + "\n");
        }
    }
}
