package algorithm.permutation.boj;

import java.util.*;
import java.io.*;

public class N과M15663 {
    int[] inputs;
    int[] seq;
    int[] ch;
    HashSet<String> visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N과M15663 main = new N과M15663();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        main.inputs = new int[N];
        main.ch = new int[N];
        main.seq = new int[M];
        main.visited = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            main.inputs[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(main.inputs);
        main.solution(0, bw);
        bw.flush();
        bw.close();
        br.close();
    }

    private void solution(int L, BufferedWriter bw) throws IOException {
        if (L == seq.length) {
            StringBuilder sb = new StringBuilder("");
            for (int n : seq) {
                sb.append(n);
                sb.append(" ");
            }
            sb.append("\n");
            if (!visited.contains(sb.toString())) {
                visited.add(sb.toString());
                bw.write(sb.toString());
            }
        } else {
            for (int i = 0; i < inputs.length; i++) {
                if (ch[i] == 0) {
                    seq[L] = inputs[i];
                    ch[i] = 1;
                    solution(L + 1, bw);
                    ch[i] = 0;
                }
            }
        }
    }
}
