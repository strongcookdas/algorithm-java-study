package algorithm.dijkstra.boj;

// https://www.acmicpc.net/problem/4485

import java.util.*;
import java.io.*;

public class 녹색옷입은애가젤다지4485 {
    static class Position implements Comparable<Position> {
        int x, y;
        int cost;

        public Position(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Position o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N;
        int cnt = 1;
        녹색옷입은애가젤다지4485 main = new 녹색옷입은애가젤다지4485();
        while ((N = Integer.parseInt(br.readLine())) != 0) {
            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            bw.write("Problem " + cnt + ": " + main.solution(N, map) + "\n");
            cnt++;
        }

        bw.flush();
        bw.close();
        br.close();

    }

    public int solution(int n, int[][] map) {
        PriorityQueue<Position> pq = new PriorityQueue<>();
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        int[][] dis = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }
        pq.offer(new Position(0, 0, map[0][0]));
        dis[0][0] = map[0][0];
        while (!pq.isEmpty()) {
            Position tmp = pq.poll();
            int nowX = tmp.x;
            int nowY = tmp.y;
            int nowCost = tmp.cost;
            if (nowX == n - 1 && nowY == n - 1) {
                return nowCost;
            }
            if (nowCost > dis[nowY][nowX]) {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n) {
                    int nextCost = map[nextY][nextX] + nowCost;
                    if (dis[nextY][nextX] > nextCost) {
                        dis[nextY][nextX] = nextCost;
                        pq.offer(new Position(nextX, nextY, nextCost));
                    }
                }
            }
        }
        return -1;
    }
}
