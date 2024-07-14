package algorithm.brute_force.boj;

import java.util.*;
import java.io.*;

public class 리모컨1107 {
    int[] numbers;
    int channel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        리모컨1107 main = new 리모컨1107();
        main.channel = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        main.numbers = new int[10];
        if (N != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int idx = Integer.parseInt(st.nextToken());
                main.numbers[idx] = 1;
            }
        }

        bw.write(String.valueOf(main.solution()));
        bw.flush();
        bw.close();
        br.close();
    }

    private int solution() {
        int answer = Math.abs(channel - 100);
        for (int i = 0; i <= 1000000; i++) {
            if (isPossible(i)) {
                int pressButton = String.valueOf(i).length() + Math.abs(channel - i);
                answer = Math.min(answer, pressButton);
            }
        }

        return answer;
    }

    private boolean isPossible(int i) {
        if (i == 0) {
            return numbers[0] == 0;
        }
        while (i > 0) {
            int idx = i % 10;
            if (numbers[idx] == 1) {
                return false;
            }
            i /= 10;
        }
        return true;
    }
}
