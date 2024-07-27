package algorithm.bfs.boj;

import java.util.*;
import java.io.*;

public class 미로탐색2178 {
    int[][] board;
    boolean[][] visited;
    int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        미로탐색2178 main = new 미로탐색2178();
        main.board = new int[N][M];
        main.visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                main.board[i][j] = input.charAt(j) - '0';
            }
        }

        System.out.println(main.bfs(N, M));

    }

    private int bfs(int N, int M) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        int steps = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                if (x == M - 1 && y == N - 1) {
                    return steps;
                }

                for (int j = 0; j < dx.length; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (nx >= 0 && nx < M && ny >= 0 && ny < N && board[ny][nx] == 1 && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}
