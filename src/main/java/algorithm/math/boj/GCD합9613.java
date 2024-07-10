package algorithm.math.boj;

import java.util.*;
import java.io.*;

public class GCD합9613 {
    int[] inputs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        GCD합9613 main = new GCD합9613();
        while ((T--) > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            main.inputs = new int[N];
            for (int i = 0; i < N; i++) {
                main.inputs[i] = Integer.parseInt(st.nextToken());
            }
            bw.write(String.valueOf(main.solution()));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private long solution() {
        long sum = 0;
        for (int i = 0; i < inputs.length; i++) {
            for (int j = i + 1; j < inputs.length; j++) {
                sum += gcd(Math.max(inputs[i], inputs[j]), Math.min(inputs[i], inputs[j]));
            }
        }
        return sum;
    }

    private long gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
