package algorithm.recursion.boj;

import java.io.*;

public class 재귀의귀재25501 {
    int ch;
    int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        재귀의귀재25501 main = new 재귀의귀재25501();

        for (int i = 0; i < N; i++) {
            main.ch = 1;
            main.count = 0;
            String input = br.readLine();
            main.solution(input, 0, input.length() - 1, 1);
            bw.write(String.valueOf(main.ch) + " " + String.valueOf(main.count) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }

    private void solution(String input, int l, int r, int count) {
        if (l >= r) {
            this.count = count;
        } else if (input.charAt(l) != input.charAt(r)) {
            this.ch = 0;
            this.count = count;
        } else {
            solution(input, l + 1, r - 1, count + 1);
        }
    }
}
