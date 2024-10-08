package algorithm.bfs.boj;

import java.util.*;

public class 데스나이트16948 {

    int[][] map;
    int[] dx = {-1, 1, -2, 2, -1, 1};
    int[] dy = {-2, -2, 0, 0, 2, 2};

    public 데스나이트16948(int N) {
        this.map = new int[N][N];
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int r1 = kb.nextInt();
        int c1 = kb.nextInt();
        int r2 = kb.nextInt();
        int c2 = kb.nextInt();

        데스나이트16948 main = new 데스나이트16948(N);
        System.out.println(main.solution(r1, c1, r2, c2));
    }

    private int solution(int r1, int c1, int r2, int c2) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r1, c1});
        this.map[r1][c1] = 1;
        int answer = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] prevP = q.poll();
                if (prevP[0] == r2 && prevP[1] == c2) {
                    return answer;
                }
                int[] nextP = new int[2];
                for (int j = 0; j < this.dx.length; j++) {
                    nextP[0] = prevP[0] + this.dy[j];
                    nextP[1] = prevP[1] + this.dx[j];
                    if (nextP[0] >= 0 && nextP[0] < this.map.length && nextP[1] >= 0 && nextP[1] < this.map.length
                            && this.map[nextP[0]][nextP[1]] == 0) {
                        q.offer(new int[]{nextP[0], nextP[1]});
                        this.map[nextP[0]][nextP[1]] = 1;
                    }
                }
            }
            answer++;
        }
        return -1;
    }
}
