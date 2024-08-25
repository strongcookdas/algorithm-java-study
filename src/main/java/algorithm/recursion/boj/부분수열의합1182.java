package algorithm.recursion.boj;

import java.util.*;
import java.io.*;

public class 부분수열의합1182 {
    int[] arr;
    int N, S;

    int answer = 0;

    public 부분수열의합1182(int N, int S) {
        this.N = N;
        this.S = S;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        부분수열의합1182 main = new 부분수열의합1182(N, S);

        main.arr = new int[N];
        for (int i = 0; i < N; i++) {
            main.arr[i] = Integer.parseInt(st.nextToken());
        }

        main.solution(0, 0);

        if (S == 0) {
            main.answer--;
        }

        bw.write(String.valueOf(main.answer));
        bw.flush();
        bw.close();
        br.close();
    }

    private void solution(int idx, int sum) {
        if (idx == N) {
            if (sum == S) {
                answer++;
            }
            return;
        }

        solution(idx + 1, sum + arr[idx]);
        solution(idx + 1, sum);
    }


}
