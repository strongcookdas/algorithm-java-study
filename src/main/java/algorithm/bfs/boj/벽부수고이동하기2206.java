package algorithm.bfs.boj;

import java.util.*;
import java.io.*;

public class 벽부수고이동하기2206 {
    boolean[][] map;
    boolean[][] ch1;
    boolean[][] ch2;

    public 벽부수고이동하기2206(int N, int M) {
        this.map = new boolean[N][M];
        this.ch1 = new boolean[N][M];
        this.ch2 = new boolean[N][M];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        벽부수고이동하기2206 main = new 벽부수고이동하기2206(N, M);
        for (int i = 0; i < N; i++) {
            String inputs = br.readLine();
            for (int j = 0; j < M; j++) {
                if (inputs.charAt(j) - '0' == 0) {
                    main.map[i][j] = true;
                }
            }
        }

        System.out.println(main.solution(N, M));
    }

    private int solution(int n, int m) {
        int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0});
        this.ch1[0][0] = true;
        int dis = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] tmp = q.poll();
                int r = tmp[0], c = tmp[1], destroy = tmp[2];
                if (r == n - 1 && c == m - 1) {
                    return dis;
                }
                for (int j = 0; j < dr.length; j++) {
                    int nr = r + dr[j];
                    int nc = c + dc[j];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                        if (destroy == 0) {
                            if (this.map[nr][nc] && !this.ch1[nr][nc]) {
                                this.ch1[nr][nc] = true;
                                q.offer(new int[]{nr, nc, 0});
                            } else if (!this.map[nr][nc] && !this.ch2[nr][nc]) {
                                this.ch2[nr][nc] = true;
                                q.offer(new int[]{nr, nc, 1});
                            }
                        } else {
                            if (this.map[nr][nc] && !this.ch2[nr][nc]) {
                                this.ch2[nr][nc] = true;
                                q.offer(new int[]{nr, nc, 1});
                            }
                        }

                    }
                }

            }
            dis++;
        }
        return -1;
    }
}