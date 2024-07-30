package algorithm.greedy.boj;

import java.util.*;
import java.io.*;

public class 행렬1080 {
    int[][] input, output;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        행렬1080 main = new 행렬1080();
        main.input = new int[N][M];
        main.output = new int[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                main.input[i][j] = input.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                main.output[i][j] = input.charAt(j) - '0';
            }
        }

        bw.write(String.valueOf(main.solution()));
        bw.flush();
        bw.close();
        br.close();
    }

    public boolean compare() {
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[0].length; j++) {
                if (output[i][j] != input[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public void change(int x, int y) {
        for (int i = y; i < y + 3; i++) {
            for (int j = x; j < x + 3; j++) {
                input[i][j] = (input[i][j] == 1) ? 0 : 1;
            }
        }
    }

    public int solution() {
        if (input.length < 3 || input[0].length < 3) {
            if (compare()) {
                return 0;
            } else {
                return -1;
            }
        }
        int answer = 0;
        for (int i = 0; i < input.length - 2; i++) {
            for (int j = 0; j < input[0].length - 2; j++) {
                if (input[i][j] != output[i][j]) {
                    change(j, i);
                    answer++;
                    if (compare()) {
                        return answer;
                    }
                }
            }
        }
        return -1;
    }
}
