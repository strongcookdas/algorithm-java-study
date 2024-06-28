package algorithm.permutation.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N과M15652 {
    int[] pm;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        N과M15652 main = new N과M15652();
        main.pm = new int[M];
        main.solution(0, N, M, 1, bw);
        bw.flush();
        bw.close();
        br.close();
    }

    private void solution(int L, int n, int m, int k, BufferedWriter bw) throws IOException {
        if (L == m) {
            StringBuilder sb = new StringBuilder("");
            for (int t : pm) {
                sb.append(t);
                sb.append(" ");
            }
            sb.append("\n");
            bw.write(sb.toString());
        } else {
            for (int i = k; i <= n; i++) {
                pm[L] = i;
                solution(L + 1, n, m, i, bw);
            }
        }
    }
}
