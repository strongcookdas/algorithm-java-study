package algorithm.permutation.boj;

import java.util.*;
import java.io.*;

public class N과M15657 {
    int[] inputs;
    int[] pm;
    HashSet<String> visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        N과M15657 main = new N과M15657();
        main.inputs = new int[N];
        main.pm = new int[M];
        main.visited = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            main.inputs[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(main.inputs);
        main.DFS(0, 0, bw);
        bw.flush();
        bw.close();
        br.close();
    }

    private void DFS(int L, int root, BufferedWriter bw) throws IOException {
        if (L == pm.length) {
            StringBuilder sb = new StringBuilder("");
            for (int n : pm) {
                sb.append(n);
                sb.append(" ");
            }
            if (!visited.contains(sb.toString())) {
                bw.write(sb.toString());
                bw.write("\n");
                visited.add(sb.toString());
            }
        } else {
            for (int i = root; i < inputs.length; i++) {
                pm[L] = inputs[i];
                DFS(L + 1, i, bw);
            }
        }
    }
}
