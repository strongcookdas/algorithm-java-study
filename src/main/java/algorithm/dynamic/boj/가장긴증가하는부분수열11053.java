package algorithm.dynamic.boj;

import java.util.*;
import java.io.*;

public class 가장긴증가하는부분수열11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] inputs = new int[N];
        for (int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        가장긴증가하는부분수열11053 main = new 가장긴증가하는부분수열11053();
        bw.write(String.valueOf(main.solution(inputs)));

        bw.flush();
        bw.close();
        br.close();
    }

    private int solution(int[] inputs) {
        int answer = 0;
        int[] dp = new int[inputs.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < inputs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (inputs[j] < inputs[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        for (int n : dp) {
            answer = Math.max(answer, n);
        }
        return answer;
    }
}
