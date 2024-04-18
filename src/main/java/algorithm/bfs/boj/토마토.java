package algorithm.bfs.boj;

import java.util.*;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class 토마토 {
    static int n, m;
    static int[] dy={-1, 0, 1, 0};
    static int[] dx={0, 1, 0, -1};
    static int[][] board, dis;
    static Queue<Point> Q = new LinkedList<>();

    public static void BFS() {
        while (!Q.isEmpty()) {
            Point tmp = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (nx >= 1 && nx <= m && ny >= 1 && ny <= n && board[ny][nx] == 0) {
                    board[ny][nx] = 1;
                    Q.offer(new Point(nx, ny));
                    dis[ny][nx] = dis[tmp.y][tmp.x] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        board = new int[n + 1][m + 1];
        dis = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                board[i][j] = kb.nextInt();
                if (board[i][j] > 0) Q.offer(new Point(j, i));
            }
        }
        BFS();
        boolean flag = true;
        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (board[i][j] == 0) flag = false;
            }
        }
        if (flag) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    answer = Math.max(answer, dis[i][j]);
                }
            }
            System.out.println(answer);
        } else System.out.println(-1);
    }
}
