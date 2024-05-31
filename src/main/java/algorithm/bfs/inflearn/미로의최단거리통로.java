package algorithm.bfs.inflearn;

import java.util.*;

class Point {
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class 미로의최단거리통로 {
    static Queue<Point> Q;
    static int[][] board;
    static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
    static int N = 7;

    public static int BFS() {
        int answer = 0;
        Q.offer(new Point(1, 1));
        board[1][1] = 1;
        while (!Q.isEmpty()) {
            int n = Q.size();
            for (int i = 0; i < n; i++) {
                Point tmp = Q.poll();
                if (tmp.x == N && tmp.y == N) return answer;
                for (int j = 0; j < dx.length; j++) {
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];
                    if (nx > 0 && nx <= N && ny > 0 && ny <= N && board[ny][nx] == 0) {
                        board[ny][nx] = 1;
                        Q.offer(new Point(nx, ny));
                    }
                }
            }
            answer++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        board = new int[N + 1][N + 1];
        Q = new LinkedList<>();
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++) board[i][j] = kb.nextInt();
        System.out.println(BFS());
    }
}
