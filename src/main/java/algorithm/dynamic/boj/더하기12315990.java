package algorithm.dynamic.boj;

import java.io.*;

public class 더하기12315990 {
    long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        더하기12315990 main = new 더하기12315990();

        int T = Integer.parseInt(br.readLine());
        int[] inputs = new int[T];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            max = Math.max(N, max);
            inputs[i] = N;
        }

        main.solution(max);

        for (int i = 0; i < T; i++) {
            bw.write(String.valueOf(main.getAnswer(inputs[i])));
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private void solution(int n) {
        dp = new long[n + 1][4];

        if (n == 0) {
            return;
        }

        if (n >= 1) {
            dp[1][1] = 1;
        }
        if (n >= 2) {
            dp[2][2] = 1;
        }
        if (n >= 3) {
            dp[3][1] = 1;
            dp[3][2] = 1;
            dp[3][3] = 1;
        }

        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= 3; j++) {
                long sum = 0;
                for (int k = 1; k <= 3; k++) {
                    if (j == k) {
                        continue;
                    }
                    sum += (dp[i - j][k]) % 1000000009;
                }
                dp[i][j] = (int) (sum % 1000000009);
            }
        }
    }

    private long getAnswer(int N) {
        return (dp[N][1] + dp[N][2] + dp[N][3]) % 1000000009;
    }
}
