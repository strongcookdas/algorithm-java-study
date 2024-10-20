package algorithm.greedy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 행렬1080 {
    int[][] map1;
    int[][] map2;

    public 행렬1080(int N, int M) {
        this.map1 = new int[N][M];
        this.map2 = new int[N][M];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        행렬1080 main = new 행렬1080(N, M);

        for (int i = 0; i < N; i++) {
            String inputs = br.readLine();
            for (int j = 0; j < M; j++) {
                main.map1[i][j] = inputs.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            String inputs = br.readLine();
            for (int j = 0; j < M; j++) {
                main.map2[i][j] = inputs.charAt(j) - '0';
            }
        }

        System.out.println(main.solution(N, M));
    }

    private boolean compare() {
        for (int i = 0; i < this.map1.length; i++) {
            for (int j = 0; j < this.map1[0].length; j++) {
                if (this.map1[i][j] != this.map2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private void change(int r, int c) {
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                this.map1[i][j] = this.map1[i][j] == 1 ? 0 : 1;
            }
        }
    }

    private int solution(int n, int m) {
        if (n < 3 || m < 3) {
            if (compare()) {
                return 0;
            }
            return -1;
        }

        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                if (this.map1[i][j] != this.map2[i][j]) {
                    count++;
                    change(i, j);
                }
            }
        }

        if (compare()) {
            return count;
        }
        return -1;
    }
}

