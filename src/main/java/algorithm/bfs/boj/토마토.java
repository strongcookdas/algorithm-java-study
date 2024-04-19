package algorithm.bfs.boj;

import java.util.*;
import java.io.*;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class 토마토 {
    static Queue<Point> Q = new LinkedList<>();
    static int m, n;
    static int t1 = 0, t2 = 0, t3 = 0;
    static int answer = Integer.MIN_VALUE;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] box, dis;

    public static void BFS() {
        while (!Q.isEmpty()) {
            Point tmp = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && box[ny][nx] == 0) {
                    box[ny][nx] = 1;
                    Q.offer(new Point(nx, ny));
                    dis[ny][nx] = dis[tmp.y][tmp.x] + 1;
                    answer = Math.max(answer, dis[ny][nx]);
                    t3++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        box = new int[n][m];
        dis = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 0) t1++;
                else if (box[i][j] == 1) {
                    t2++;
                    Q.offer(new Point(j, i));
                }
            }
        }

        if (t1 == 0 && t2 > 0) answer = 0;
        else {
            BFS();
            if (t1 != t3) answer = -1;
        }
        System.out.println(answer);
    }
}
