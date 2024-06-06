package algorithm.dfs.boj;
/**
 * DFS, 백트래킹 활용
 * 과정
 * 빈칸을 찾는다
 * 채울 숫자에 대한 유효성 검사를 한다.
 * 백트래킹 구현
 * 구현해야할 함수
 * 빈칸을 찾는 함수
 * 유효성 검사 함수
 * 스도쿠를 푸는 함수
 * 출력하는 함수
 */

import java.util.*;
import java.io.*;

public class 스도쿠2580 {
    class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int[][] arr = new int[9][9];

    private Point findEmpty() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (arr[i][j] == 0) return new Point(j, i);
            }
        }
        return null;
    }

    private boolean validCheck(Point p, int n) {
        for (int i = 0; i < 9; i++) {
            if (arr[i][p.x] == n || arr[p.y][i] == n) {
                return false;
            }
        }

        int nx = 3 * (p.x / 3);
        int ny = 3 * (p.y / 3);
        for (int i = ny; i < ny + 3; i++) {
            for (int j = nx; j < nx + 3; j++) {
                if (arr[i][j] == n) return false;
            }
        }

        return true;
    }

    public String getArrToString() {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public boolean solvedProblem() {
        Point p = findEmpty();
        if (p == null) {
            return true;
        }
        for (int i = 1; i <= 9; i++) {
            if (validCheck(p, i)) {
                arr[p.y][p.x] = i;
                if (solvedProblem()) return true;
                arr[p.y][p.x] = 0;
            }

        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        스도쿠2580 main = new 스도쿠2580();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                main.arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (main.solvedProblem()) System.out.println(main.getArrToString());

    }
}
