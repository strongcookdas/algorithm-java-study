package algorithm.dfs.inflearn;

import java.util.*;

public class 미로탐색 {
    static int[][] arr;
    static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
    static int N = 7, answer = 0;

    public static void DFS(int x, int y) {
        if (x == N && y == N) answer++;
        else {
            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 1 && nx <= N && ny >= 1 && ny <= N && arr[ny][nx] == 0) {
                    arr[ny][nx] = 1;
                    DFS(nx, ny);
                    arr[ny][nx] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        arr = new int[N+1][N+1];
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++) arr[i][j] = kb.nextInt();
        arr[1][1]=1;
        DFS(1, 1);
        System.out.println(answer);
    }
}
