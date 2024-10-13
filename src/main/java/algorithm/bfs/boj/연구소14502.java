package algorithm.bfs.boj;

import java.util.*;
import java.io.*;

public class 연구소14502 {
    int[][] map;

    public 연구소14502(int N, int M) {
        this.map = new int[N][M];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        연구소14502 main = new 연구소14502(N, M);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                main.map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(main.solution(N, M));

    }

    private int solution(int n, int m) {
        int answer = Integer.MIN_VALUE;
        for (int i1 = 0; i1 < n; i1++) {
            for (int j1 = 0; j1 < m; j1++) {
                int r1 = i1, c1 = j1;
                if (this.map[r1][c1] != 0) {
                    continue;
                }

                this.map[r1][c1] = 1;
                for (int i2 = 0; i2 < n; i2++) {
                    for (int j2 = 0; j2 < m; j2++) {
                        int r2 = i2, c2 = j2;
                        if (this.map[r2][c2] != 0) {
                            continue;
                        }

                        this.map[r2][c2] = 1;
                        for (int i3 = 0; i3 < n; i3++) {
                            for (int j3 = 0; j3 < m; j3++) {
                                int r3 = i3, c3 = j3;
                                if (this.map[r3][c3] != 0) {
                                    continue;
                                }

                                this.map[r3][c3] = 1;
                                int area = getArea(n, m);
                                answer = Math.max(answer, area);
                                this.map[r3][c3] = 0;
                            }
                        }
                        this.map[r2][c2] = 0;
                    }
                }
                this.map[r1][c1] = 0;
            }
        }
        return answer;
    }

    private int getArea(int n, int m) {
        int count = 0;
        boolean[][] ch = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (this.map[i][j] == 2) {
                    bfs(i, j, n, m, ch);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!ch[i][j] && this.map[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(int r, int c, int n, int m, boolean[][] ch) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        ch[r][c] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] p = q.poll();
                for (int j = 0; j < dr.length; j++) {
                    int nr = p[0] + dr[j];
                    int nc = p[1] + dc[j];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < m && this.map[nr][nc] == 0 && !ch[nr][nc]) {
                        ch[nr][nc] = true;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
        }
    }
}
