package algorithm.dfs.inflearn;

import java.util.*;

public class 미로탐색 {
    static int answer = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] arr = new int[7][7];

    public static void DFS(int x, int y) {
        if (x == 6 && y == 6) {
            answer++;
            return;
        }
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < 7 && ny >= 0 && ny < 7 && arr[ny][nx] == 0) {
                arr[ny][nx] = 1;
                DFS(nx,ny);
                arr[ny][nx] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                arr[i][j] = kb.nextInt();
            }
        }
        arr[0][0] = 1;
        DFS(0, 0);
        System.out.println(answer);
    }
}
