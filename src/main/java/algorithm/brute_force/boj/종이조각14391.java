package algorithm.brute_force.boj;

import java.util.*;
import java.io.*;

public class 종이조각14391 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = input.charAt(j) - '0';
            }
        }

        종이조각14391 main = new 종이조각14391();
        bw.write(main.solution(board, N, M));
        bw.flush();
        bw.close();
        br.close();
    }

    private String solution(int[][] board, int n, int m) {
        int answer = 0;
        int total = 1 << (n * m);
        for (int t = 0; t < total; t++) {
            int sum = 0;

            for (int i = 0; i < n; i++) {
                int currentNumber = 0;
                for (int j = 0; j < m; j++) {
                    int idx = i * m + j;
                    if ((t & (1 << idx)) != 0) {
                        currentNumber = currentNumber * 10 + board[i][j];
                    } else {
                        sum += currentNumber;
                        currentNumber = 0;
                    }
                }
                sum += currentNumber;
            }

            for (int j = 0; j < m; j++) {
                int currentNumber = 0;
                for (int i = 0; i < n; i++) {
                    int idx = i * m + j;
                    if ((t & (1 << idx)) == 0) {
                        currentNumber = currentNumber * 10 + board[i][j];
                    } else {
                        sum += currentNumber;
                        currentNumber = 0;
                    }
                }
                sum += currentNumber;
            }
            answer = Math.max(answer, sum);
        }
        return String.valueOf(answer);
    }
}
