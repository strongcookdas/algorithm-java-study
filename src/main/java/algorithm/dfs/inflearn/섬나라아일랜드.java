package algorithm.dfs.inflearn;
/*
1. arr를 순회
2. 1인 영역 DFS 탐색 (상,하,좌,우,대각선)
3. 방문한 곳은 0으로 체크
4. BFS 탐색이 끝나면 개수 +1
5. 2번 반복

수정 후
1. arr를 순회
2. 1인 영역 DFS 탐색 (answer +1)
3. 방문한 곳은 0으로 체크
4. 상,하,좌,우,대각선 탐색
5. 2번 반복
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class 섬나라아일랜드 {
    static int N, answer = 0;
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1,}, dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[][] map;
    static Queue<Point> Q;

    public static void BFS() {
        while (!Q.isEmpty()) {
            int n = Q.size();
            for (int i = 0; i < n; i++) {
                Point tmp = Q.poll();
                for (int j = 0; j < dx.length; j++) {
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[ny][nx] == 1) {
                        map[ny][nx] = 0;
                        Q.offer(new Point(nx, ny));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Q = new LinkedList<>();
        N = kb.nextInt();
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = kb.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    answer++;
                    map[i][j] = 0;
                    Q.offer(new Point(j, i));
                    BFS();
                }
            }
        }
        BFS();
        System.out.println(answer);
    }
}
