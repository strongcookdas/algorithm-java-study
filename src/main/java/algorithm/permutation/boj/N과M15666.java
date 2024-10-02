package algorithm.permutation.boj;

import java.util.*;
import java.io.*;

public class N과M15666 {
    int[] nums;
    int[] pm;
    HashSet<String> ch;

    public N과M15666(int n, int m) {
        this.nums = new int[n];
        this.pm = new int[m];
        this.ch = new HashSet<>();
    }

    public static void main(String[] args) throws IOException {
        Scanner kb = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = kb.nextInt();
        int M = kb.nextInt();

        N과M15666 main = new N과M15666(N, M);
        for (int i = 0; i < N; i++) {
            main.nums[i] = kb.nextInt();
        }

        Arrays.sort(main.nums);
        main.solution(0, 0, bw);

        bw.flush();
        bw.close();

    }

    private void solution(int L, int k, BufferedWriter bw) throws IOException {
        if (L == this.pm.length) {
            StringBuilder sb = new StringBuilder("");
            for (int n : this.pm) {
                sb.append(n);
                sb.append(" ");
            }
            if (!this.ch.contains(sb.toString())) {
                bw.write(sb.toString());
                bw.write("\n");
                this.ch.add(sb.toString());
            }
        } else {
            for (int i = k; i < this.nums.length; i++) {
                this.pm[L] = nums[i];
                solution(L + 1, i, bw);
            }
        }
    }
}
