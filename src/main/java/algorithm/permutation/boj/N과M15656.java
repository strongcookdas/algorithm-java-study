package algorithm.permutation.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class N과M15656 {
    int[] numbers;
    int[] pm;
    HashSet<String> visitied = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        N과M15656 main = new N과M15656();
        main.numbers = new int[N];
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
                pm[i] = numbers[j];
                permutation(i + 1, k, bw);
            }
        }
    }
}
