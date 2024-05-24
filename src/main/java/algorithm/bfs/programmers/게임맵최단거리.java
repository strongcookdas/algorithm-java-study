package algorithm.bfs.programmers;

import java.util.*;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class 게임맵최단거리 {
    static int[][] ch;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static Queue<Point> Q = new LinkedList<>();

    public static int solution(int[][] map) {
        int answer = 0;
        ch = new int[101][101];
        Q.offer(new Point(0, 0));
        ch[0][0] = 1;
        while (!Q.isEmpty()) {
            int n = Q.size();
            for (int i = 0; i < n; i++) {
                Point tmp = Q.poll();
                if (tmp.x == map[0].length - 1 && tmp.y == map.length - 1) return answer;
                for (int j = 0; j < dx.length; j++) {
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];
                    if (nx >= 0 && nx < map[0].length && ny >= 0 && ny < map.length && map[ny][nx] == 1 && ch[ny][nx] == 0) {
                        Q.offer(new Point(nx, ny));
                        ch[ny][nx] = 1;
                    }
                }
            }
            answer++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        System.out.println(solution(arr));
    }
}
