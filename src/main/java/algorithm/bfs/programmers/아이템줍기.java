package algorithm.bfs.programmers;

import java.util.*;
public class 아이템줍기 {
    static class Point{
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    int[][] map = new int[55][55];
    int[][] visited = new int[55][55];
    int[] dx = {0,1,0,-1}, dy = {1,0,-1,0};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;

        for(int[] r : rectangle){
            for(int i = r[1]; i<=r[3]; i++){
                for(int j = r[0]; j<=r[2]; j++){
                    if(i==r[1]||i==r[3]||j==r[0]||j==r[2]) map[i][j] += 1;
                    else map[i][j] += -10;
                }
            }
        }

        answer = BFS(characterX, characterY, itemX, itemY);
        for (int i = 0; i < 55; i++) {
            for (int j = 0; j < 55; j++) {
                if(map[i][j]==1) System.out.println(j+" "+i);
            }
        }
        return answer;
    }

    private int BFS(int cX, int cY, int iX, int iY){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(cX,cY));
        visited[cY][cX] = 1;
        int count = 0;
        while(!q.isEmpty()){
            int n = q.size();
            for(int i = 0; i<n; i++){
                Point tmp = q.poll();
                if(tmp.x == iX && tmp.y == iY) return count;
                for(int j = 0; j<dx.length; j++){
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];
                    if(nx>=0 && nx<55 && ny>=0 && ny<55 && map[ny][nx]>0 && visited[ny][nx] == 0){
                        visited[ny][nx] = 1;
                        q.offer(new Point(nx,ny));
                    }
                }
            }
            count++;
        }
        return -1;
    }

    public static void main(String[] args) {
        아이템줍기 main = new 아이템줍기();
        int[][] arr = {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
        main.solution(arr, 1, 3, 7,8);
    }
}
