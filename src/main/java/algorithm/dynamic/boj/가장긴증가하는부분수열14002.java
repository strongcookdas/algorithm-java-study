package algorithm.dynamic.boj;

import java.util.*;
import java.io.*;

public class 가장긴증가하는부분수열14002 {
    int[] root;
    int[] dp;
    int maxIdx = 0;
    int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        가장긴증가하는부분수열14002 main = new 가장긴증가하는부분수열14002();
        bw.write(main.solution(arr) + "\n");

        int idx = main.maxIdx;
        ArrayList<Integer> list = new ArrayList<>();
        while (true) {
            if (idx == -1) {
                break;
            }
            list.add(arr[idx]);
            idx = main.root[idx];
        }
        
        for (int i = list.size() - 1; i >= 0; i--) {
            bw.write(list.get(i) + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private String solution(int[] arr) {
        dp = new int[arr.length];
        root = new int[arr.length];
        Arrays.fill(dp, 1);
        Arrays.fill(root, -1);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    root[i] = j;
                }
            }
            if (dp[i] > answer) {
                answer = dp[i];
                maxIdx = i;
            }
        }
        return String.valueOf(answer);
    }
}
