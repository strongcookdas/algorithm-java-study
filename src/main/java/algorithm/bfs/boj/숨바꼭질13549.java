package algorithm.bfs.boj;

//https://www.acmicpc.net/problem/13549

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 숨바꼭질13549 {
    static class Position {
        int x;
        int time;

        public Position(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        System.out.println(solution(A, B));
    }

    public static int solution(int A, int B) {
        Queue<Position> q = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        q.offer(new Position(A, 0));
        visited[A] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Position tmp = q.poll();
                if (tmp.x == B) {
                    return tmp.time;
                }

                int nextX1 = tmp.x*2;
                int nextX2 = tmp.x-1;
                int nextX3 = tmp.x+1;

                if (nextX1 >= 0 && nextX1< visited.length && !visited[nextX1]) {
                    q.offer(new Position(nextX1, tmp.time));
                    visited[nextX1]=true;
                }
                if (nextX2 >= 0 && nextX2< visited.length && !visited[nextX2]) {
                    q.offer(new Position(nextX2, tmp.time+1));
                    visited[nextX2]=true;
                }
                if (nextX3 >= 0 && nextX3< visited.length && !visited[nextX3]) {
                    q.offer(new Position(nextX3, tmp.time+1));
                    visited[nextX3]=true;
                }
            }
        }
        return -1;
    }

}
