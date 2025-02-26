package algorithm.math.boj;

import java.io.*;

public class 일4375 {
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String n = "";
    while ((n = br.readLine()) != null) {
        int result = solution(n);
        bw.write(result + "\n");
    }

    br.close();
    bw.flush();
    bw.close();
}

    public static int solution(String n) {
        int div = Integer.parseInt(n);
        int cnt = 0;
        int rem = 0;
        while (true) {
            cnt++;
            rem = (rem * 10 + 1) % div;
            if (rem == 0) {
                return cnt;
            }
        }
    }
}
