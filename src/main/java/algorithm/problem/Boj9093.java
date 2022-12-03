package algorithm.problem;

import java.io.*;

public class Boj9093 {
    // 백준 9093 단어 뒤집기
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());

        while (cnt-- > 0) {
            String[] arr = br.readLine().split(" ");
            String reverse = "";
            for (String str : arr) {
                StringBuffer sb = new StringBuffer(str);
                reverse += sb.reverse().toString() + " ";
            }
            bw.write(reverse + "\n");
        }

        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        Boj9093 problem = new Boj9093();
        problem.solution();
    }
}
