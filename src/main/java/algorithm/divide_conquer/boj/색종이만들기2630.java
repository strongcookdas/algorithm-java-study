package algorithm.divide_conquer.boj;

import java.util.*;
import java.io.*;

public class 색종이만들기2630 {
    int white = 0;
    int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        색종이만들기2630 main = new 색종이만들기2630();
        main.solution(0, 0, map.length, map);
        System.out.println(main.white);
        System.out.println(main.blue);

        br.close();
    }

    private void solution(int row, int col, int size, int[][] map) {
        int flag = checkPaper(row, col, size, map);
        if (flag == -1) {
            int resize = size / 2;
            solution(row, col, resize, map);
            solution(row + resize, col + resize, resize, map);
            solution(row, col + resize, resize, map);
            solution(row + resize, col, resize, map);
        } else {
            if (flag == 1) {
                this.blue++;
            } else {
                this.white++;
            }
        }
    }

    private int checkPaper(int row, int col, int size, int[][] map) {
        int color = map[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (color != map[i][j]) {
                    return -1;
                }
            }
        }
        return color;
    }
}
