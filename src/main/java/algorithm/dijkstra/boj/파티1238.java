package algorithm.dijkstra.boj;

//https://www.acmicpc.net/problem/1238
import java.util.ArrayList;
import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 파티1238 {
    static class Position implements Comparable<Position> {
        int d;
        int c;

        public Position(int d, int c) {
            this.d = d;
            this.c = c;
        }

        @Override
        public int compareTo(Position p) {
            return this.c - p.c;
        }
    }

    ArrayList<ArrayList<Position>> graph;
    int answer;

    public 파티1238(int n) {
        this.graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            this.graph.add(new ArrayList<>());
        }
        this.answer = Integer.MIN_VALUE;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        파티1238 main = new 파티1238(n);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            main.graph.get(s).add(new Position(d, c));
        }

        for (int i = 1; i <= n; i++) {
            main.answer = Math.max(main.answer, main.solution(i, x));
        }
        System.out.println(main.answer);
    }

    public int getDis(int s, int d) {
        PriorityQueue<Position> pq = new PriorityQueue<>();
        int[] dis = new int[this.graph.size()];
        Arrays.fill(dis, Integer.MAX_VALUE);
        pq.offer(new Position(s, 0));
        dis[s] = 0;
        while (!pq.isEmpty()) {
            int size = pq.size();
            for (int i = 0; i < size; i++) {
                Position tmp = pq.poll();
                int now = tmp.d;
                int nowDis = tmp.c;
                if (now == d) {
                    return nowDis;
                }
                if (dis[now] < nowDis) {
                    continue;
                }
                for (Position p : this.graph.get(now)) {
                    if (dis[p.d] > nowDis + p.c) {
                        dis[p.d] = nowDis + p.c;
                        pq.offer(new Position(p.d, dis[p.d]));
                    }
                }
            }
        }
        return -1;
    }

    public int solution(int s, int d) {
        int totalDis = getDis(s, d) + getDis(d, s);
        return totalDis;
    }
}