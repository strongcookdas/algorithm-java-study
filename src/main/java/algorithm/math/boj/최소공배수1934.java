package algorithm.math.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 최소공배수1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        최소공배수1934 main = new 최소공배수1934();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(main.lcm(Math.max(a, b), Math.min(a, b)) + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private int lcm(int max, int min) {
        int gcd = gcd(max, min);
        return (max * min) / gcd;
    }

    private int gcd(int max, int min) {
        if (max % min == 0) {
            return min;
        }
        return gcd(min, max % min);
    }
}
