package algorithm.dfs.boj;

import java.io.*;
import java.util.StringTokenizer;

public class N과M15651 {
    int[] pm;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        N과M15651 main = new N과M15651();
        main.pm = new int[M];
        main.solution(0, N, M, bw);
        bw.flush();
        bw.close();
        br.close();
    }

    private void solution(int L, int n, int m, BufferedWriter bw) throws IOException {
        if (L == m) {
            StringBuilder sb = new StringBuilder("");
            for (int t : pm) {
                sb.append(t);
                sb.append(" ");
            }
            sb.append("\n");
            bw.write(sb.toString());
        } else {
            for (int i = 1; i <= n; i++) {
                pm[L] = i;
                solution(L + 1, n, m, bw);
            }
        }
    }
}
