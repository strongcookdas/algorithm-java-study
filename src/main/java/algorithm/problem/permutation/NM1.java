package algorithm.problem.permutation;

import java.io.*;

// 백준 N과 M(1)
public class NM1 {
    int n;
    int r;
    boolean[] checkList;
    int[] result;

    public NM1(int n, int r) {
        this.n = n;
        this.r = r;
        checkList = new boolean[n];
        result = new int[r];
    }

    public void permutation(BufferedWriter bw, int depth) throws IOException {
        if (depth == r) {
            for (int num : result) {
                bw.write(num + " ");
            }
            bw.write("\n");
        } else {
            for (int i = 1; i <= n; i++) {
                if (checkList[i - 1] == true) continue;
                else {
                    result[depth] = i;
                    checkList[i - 1] = true;
                    permutation(bw, depth + 1);
                    checkList[i - 1] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int r = Integer.parseInt(strs[1]);

        NM1 p = new NM1(n, r);
        p.permutation(bw, 0);
        bw.flush();
    }
}
