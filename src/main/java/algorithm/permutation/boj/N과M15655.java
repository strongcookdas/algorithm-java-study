package algorithm.permutation.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class N과M15655 {
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

        N과M15655 main = new N과M15655();
        main.numbers = new int[N];
        main.ch = new int[N];
        main.pm = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            main.numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(main.numbers);

        main.permutation(0, M, 0, bw);

        bw.flush();
        bw.close();
        br.close();
    }

    private void permutation(int i, int k, int z, BufferedWriter bw) throws IOException {
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
            for (int j = z; j < numbers.length; j++) {
                if (ch[j] == 0) {
                    ch[j] = 1;
                    pm[i] = numbers[j];
                    permutation(i + 1, k, j + 1, bw);
                    ch[j] = 0;
                }
            }
        }
    }
}
