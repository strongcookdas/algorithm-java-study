package algorithm.combination.boj;

import java.util.*;
import java.io.*;

public class 로또6603 {
    int[] combi;
    int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;
        로또6603 main = new 로또6603();
        main.combi = new int[6];
        while ((input = br.readLine()) != null) {
            if (input.equals("0")) {
                break;
            }
            StringTokenizer st = new StringTokenizer(input);
            int K = Integer.parseInt(st.nextToken());
            main.numbers = new int[K];
            for (int i = 0; i < K; i++) {
                main.numbers[i] = Integer.parseInt(st.nextToken());
            }
            main.DFS(0, 0, bw);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private void DFS(int L, int root, BufferedWriter bw) throws IOException {
        if (L == 6) {
            for (int n : combi) {
                bw.write(String.valueOf(n));
                bw.write(" ");
            }
            bw.write("\n");
        } else {
            for (int i = root; i < numbers.length; i++) {
                combi[L] = numbers[i];
                DFS(L + 1, i + 1, bw);
            }
        }
    }
}
