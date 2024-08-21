package algorithm.bfs.boj;

import java.util.*;
import java.io.*;

public class 알고스팟1261 {
    int[][] map;
    int[][] dis;
    int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};

    static class Node {
        int x, y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        알고스팟1261 main = new 알고스팟1261();
        main.map = new int[M][N];
        main.dis = new int[M][N];

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                main.map[i][j] = input.charAt(j) - '0';
                main.dis[i][j] = Integer.MAX_VALUE;
            }
        }

        bw.write(String.valueOf(main.solution(N, M)));
        bw.flush();
        bw.close();
        br.close();
    }

    private int solution(int n, int m) {
        Deque<Node> dq = new ArrayDeque<>();
        dq.offer(new Node(0, 0, 0));
        dis[0][0] = 0;

        while (!dq.isEmpty()) {
            Node tmp = dq.poll();
            int x = tmp.x;
            int y = tmp.y;
            int cost = tmp.cost;

            if (x == n - 1 && y == m - 1) {
                return cost;
            }

            for (int j = 0; j < dx.length; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    int nextCost = cost + map[ny][nx];

                    if (nextCost < dis[ny][nx]) {
                        dis[ny][nx] = nextCost;

                        if (map[ny][nx] == 1) {
                            dq.offerLast(new Node(nx, ny, nextCost));
                        } else {
                            dq.offerFirst(new Node(nx, ny, nextCost));
                        }
                    }
                }
            }
        }
        return 0;
    }


}
