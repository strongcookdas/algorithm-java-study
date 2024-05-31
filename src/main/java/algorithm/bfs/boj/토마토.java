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
    static int M, N, day = 0;
    static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
    static int[][] box, dis;
    static Queue<Point> Q;

    public static void BFS() {
        while (!Q.isEmpty()) {
            int n = Q.size();
            for (int i = 0; i < n; i++) {
                Point tmp = Q.poll();
                for (int j = 0; j < dx.length; j++) {
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];
                    if (nx > 0 && nx <= M && ny > 0 && ny <= N && box[ny][nx]==0 ) {
                        box[ny][nx] = 1;
                        dis[ny][nx] = dis[tmp.y][tmp.x] + 1;
                        Q.offer(new Point(nx,ny));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        M = kb.nextInt();
        N = kb.nextInt();
        box = new int[N + 1][M + 1];
        dis = new int[N + 1][M + 1];
        Q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                box[i][j] = kb.nextInt();
                if(box[i][j] == 1) Q.offer(new Point(j,i));
            }
        }
        BFS();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                day = Math.max(dis[i][j], day);
            }
        }
        System.out.println(day);
    }
}
