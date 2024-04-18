package algorithm.dfs.inflearn;

import java.util.*;

public class 미로탐색 {
    static int answer = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] arr = new int[7][7], visit = new int[7][7];

    public static void DFS(int x, int y) {
        if (x == 6 && y == 6) {
            answer++;
            return;
        }
        if (x < 0 || x >= 7 || y < 0 || y >= 7) return;
        if (arr[y][x] != 0 || visit[y][x] != 0) return;
        for (int i = 0; i < dx.length; i++) {
            visit[y][x] = 1;
            DFS(x + dx[i], y + dy[i]);
            visit[y][x] = 0;
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                arr[i][j] = kb.nextInt();
            }
        }
        DFS(0, 0);
        System.out.println(answer);
    }
}
