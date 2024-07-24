package algorithm.string.bog;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 팰린드롬8892 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        팰린드롬8892 main = new 팰린드롬8892();

        while ((T--) > 0) {
            int N = Integer.parseInt(br.readLine());
            String[] inputs = new String[N];
            for (int i = 0; i < N; i++) {
                inputs[i] = br.readLine();
            }
            bw.write(main.solution((inputs)));
            bw.write("\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private String solution(String[] inputs) {
        for (int i = 0; i < inputs.length; i++) {
            for (int j = 0; j < inputs.length; j++) {
                if (i == j) {
                    continue;
                }
                StringBuilder sb = new StringBuilder("");
                sb.append(inputs[i]);
                sb.append(inputs[j]);

                if (sb.toString().contentEquals(sb.reverse())) {
                    return sb.toString();
                }
            }
        }
        return "0";
    }
}
