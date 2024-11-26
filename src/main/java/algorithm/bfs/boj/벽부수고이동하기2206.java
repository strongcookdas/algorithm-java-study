package algorithm.bfs.boj;

// https://www.acmicpc.net/problem/2206

import java.util.*;
import java.io.*;

public class 벽부수고이동하기2206 {
    static class Position {
        int x, y;
        boolean status;

        public Position(int x, int y, boolean status) {
            this.x = x;
            this.y = y;
            this.status = status;
        }
    }

    Queue<Position> q;
    int[][] map;
    boolean[][] ch1;
    boolean[][] ch2;

    public 벽부수고이동하기2206(int n, int m) {
        this.q = new LinkedList<>();
        this.ch1 = new boolean[n + 1][m + 1];
        this.ch2 = new boolean[n + 1][m + 1];
        this.map = new int[n + 1][m + 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        벽부수고이동하기2206 main = new 벽부수고이동하기2206(N, M);
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                int tmp = input.charAt(j) - '0';
                main.map[i + 1][j + 1] = tmp;
            }
        }

        System.out.println(main.solution(N, M));
    }

    public int solution(int n, int m) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        int count = 1;

        this.ch1[1][1] = true;
        this.q.offer(new Position(1, 1, false));

        while (!this.q.isEmpty()) {
            int size = this.q.size();
            for (int i = 0; i < size; i++) {
                Position tmp = this.q.poll();
                if (tmp.x == m && tmp.y == n) {
                    return count;
                }
                for(int j = 0; j<4; j++){
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];
                    if(nx>0 && nx<=m && ny>0 && ny<=n){
                        if(tmp.status){
                            if(this.map[ny][nx]==0 && !this.ch2[ny][nx]){
                                this.ch2[ny][nx] = true;
                                this.q.offer(new Position(nx, ny, true));
                            }
                        }else{
                            if(this.map[ny][nx]==0 && !this.ch1[ny][nx]){
                                this.q.offer(new Position(nx,ny,false));
                                this.ch1[ny][nx] = true;
                            }else if(this.map[ny][nx]==1 && !this.ch2[ny][nx]){
                                this.q.offer(new Position(nx, ny, true));
                                this.ch2[ny][nx] = true;
                            }
                        }
                    }
                }
            }
            count++;
        }
        return -1;
    }
}