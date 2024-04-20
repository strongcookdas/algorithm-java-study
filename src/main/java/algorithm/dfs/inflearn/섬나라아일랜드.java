package algorithm.dfs.inflearn;
/*
1. arr를 순회
2. 1인 영역 DFS 탐색 (상,하,좌,우,대각선)
3. 방문한 곳은 0으로 체크
4. DFS 탐색이 끝나면 개수 +1
5. 2번 반복
 */

import java.util.*;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class 섬나라아일랜드 {
    static int n, answer = 0;
    static int[][] board;
    static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
    static boolean flag = false;

    public static void DFS(Point p) {
        if (board[p.y][p.x] != 1) return;
        board[p.y][p.x] = 0;
        flag = true;
        for (int i = 0; i < 8; i++) {
            int nx = p.x + dx[i];
            int ny = p.y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[ny][nx] != 1) continue;
//            for(int j = 0; j<n; j++){
//                for(int k = 0; k<n; k++){
//                    System.out.print(board[j][k]);
//                }
//                System.out.println();
//            }
//            System.out.println();
            DFS(new Point(nx, ny));
        }
    }

    public static void solution() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                DFS(new Point(j, i));
                if (flag) answer++;
                flag = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) board[i][j] = kb.nextInt();
        }
        solution();
        System.out.println(answer);
    }
}
