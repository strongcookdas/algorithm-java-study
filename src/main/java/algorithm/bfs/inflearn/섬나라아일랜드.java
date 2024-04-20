package algorithm.bfs.inflearn;

/*
1. board 순회
2. 1인곳 q에 넣는다.
3. q에 좌표값이 없을 때까지 bfs의 반복문 순회
4. 방문한 곳은 0으로 변경 후 거리 값 구하기
5. 거리값이 1이면 answer++ : 1인 곳이 섬의 시작점이기 때문
------------------------------------------------------> 대각선에 이어진 섬을 탐색 못함

수정
1. board 순회
2. 1인 영역을 만나면 answer+1후 q에 넣는다 그리고 0으로 변경 후 bfs 호출.
3. q의 원소가 0개일때까지 bfs의 반복문 순회
4. 2번 반복
- 위의 과정과 차이점 : dis를 구하지 않는다.
*/

import java.util.*;

public class 섬나라아일랜드 {

    static int n, answer = 0;
    static int[][] board;
    static Queue<Point> q = new LinkedList<>();
    static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};

    public static void BFS() {
        while (!q.isEmpty()) {
            Point tmp = q.poll();
            for (int i = 0; i < 8; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[ny][nx] != 1) continue;
                board[ny][nx] = 0;
                q.offer(new Point(nx, ny));
            }
        }
    }

    public static void solution(){
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(board[i][j]==1){
                    answer++;
                    board[i][j] = 0;
                    q.offer(new Point(j,i));
                    BFS();
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = kb.nextInt();
            }
        }
        solution();
        System.out.println(answer);
    }
}
