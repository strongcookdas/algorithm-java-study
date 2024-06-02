package algorithm.bfs.boj;

import java.io.*;
import java.util.*;

public class 영역구하기2583 {
    static int M, N, K, total = 0;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
    static Queue<Point> Q;
    static ArrayList<Integer> list;

    public static void checkPoint(Point p1, Point p2) {
        for (int i = p1.y; i < p2.y; i++) {
            for (int j = p1.x; j < p2.x; j++) {
                map[i][j] = 1;
            }
        }
    }

    public static void BFS() {
        int width = 1;
        while (!Q.isEmpty()) {
            int n = Q.size();
            for (int i = 0; i < n; i++) {
                Point tmp = Q.poll();
                for (int j = 0; j < dx.length; j++) {
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[ny][nx] == 0) {
                        map[ny][nx] = 1;
                        Q.offer(new Point(nx, ny));
                        width++;
                    }
                }
            }
        }
        list.add(width);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            Point p1 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Point p2 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            checkPoint(p1, p2);
        }
        list = new ArrayList<>();
        Q = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {
                    Q.offer(new Point(j, i));
                    map[i][j] = 1;
                    total++;
                    BFS();
                }
            }
        }
        Collections.sort(list);
        System.out.println(total);
        for (int width : list) System.out.print(width + " ");
    }
}
