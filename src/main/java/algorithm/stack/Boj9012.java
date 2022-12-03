package algorithm.stack;

import java.io.*;

public class Boj9012 {

    public String logic(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') cnt++;
            else if (str.charAt(i) == ')') {
                if (cnt <= 0) return "NO";
                else cnt--;
            }
        }

        return (cnt == 0) ? "YES" : "NO";
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());

        while (cnt-- > 0) {
            String str = br.readLine();
            bw.write(this.logic(str) + "\n");
        }

        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        Boj9012 problem = new Boj9012();
        problem.solution();
    }
}
