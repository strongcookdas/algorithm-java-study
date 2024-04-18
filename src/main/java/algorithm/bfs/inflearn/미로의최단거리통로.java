package algorithm.bfs.inflearn;

import java.util.*;

public class 미로의최단거리통로 {
    static int answer = Integer.MAX_VALUE;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] board = new int[7][7];

    public static void DFS(int x, int y, int dist) {
        if (x == 6 && y == 6) {
            answer = Math.min(answer, dist);
            return;
        }
        if (dist > answer) return;
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < 7 && ny >= 0 && ny < 7 && board[ny][nx] == 0) {
                board[ny][nx] = 1;
                DFS(nx, ny, dist + 1);
                board[ny][nx] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) board[i][j] = kb.nextInt();
        }
        board[0][0] = 1;
        DFS(0, 0, 0);
        System.out.println((answer == Integer.MAX_VALUE) ? -1 : answer);
    }

}
