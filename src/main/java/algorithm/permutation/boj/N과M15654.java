package algorithm.permutation.boj;

import java.util.*;
import java.io.*;

public class N과M15654 {
    int[] numbers;
    int[] pm;
    int[] ch;
    HashSet<String> visitied = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        N과M15654 main = new N과M15654();
        main.numbers = new int[N];
        main.ch = new int[N];
        main.pm = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            main.numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(main.numbers);

        main.permutation(0, M, bw);

        bw.flush();
        bw.close();
        br.close();
    }

    private void permutation(int i, int k, BufferedWriter bw) throws IOException {
        if (i == k) {
            StringBuilder sb = new StringBuilder("");
            for (int p : pm) {
                sb.append(p);
                sb.append(" ");
            }
            if (!visitied.contains(sb.toString())) {
                visitied.add(sb.toString());
                bw.write(sb.toString() + "\n");
            }
        } else {
            for (int j = 0; j < numbers.length; j++) {
                if (ch[j] == 0) {
                    ch[j] = 1;
                    pm[i] = numbers[j];
                    permutation(i + 1, k, bw);
                    ch[j] = 0;
                }
            }
        }
    }
}
