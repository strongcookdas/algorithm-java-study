package algorithm.dynamic.boj;

import java.io.*;
import java.util.*;

public class 연속합1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        연속합1912 main = new 연속합1912();
        System.out.println(main.solution(arr));

    }

    private int solution(int[] arr) {
        int answer = arr[0];
        int[] dp = new int[arr.length];
        dp[0] = answer;
        for (int i = 1; i < arr.length; i++) {
            int sum = dp[i - 1] + arr[i];
            if (sum > arr[i]) {
                dp[i] = sum;
            } else {
                dp[i] = arr[i];
            }
            answer = Math.max(answer, dp[i]);
        }
        return answer;
    }
}
