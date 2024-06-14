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
    int[][] map = new int[120][120];
    int[][] visited = new int[120][120];
    int[] dx = {0,1,0,-1}, dy = {1,0,-1,0};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;

        for(int[] r : rectangle){
            int sRow = r[1]*2, eRow = r[3]*2;
            int sCol = r[0]*2, eCol = r[2]*2;
            for(int i = sRow; i<=eRow; i++){
                for(int j = sCol; j<=eCol; j++){
                    if(i==sRow||i==eRow||j==sCol||j==eCol) map[i][j] += 1;
                    else map[i][j] += -10;
                }
            }
        }

        answer = BFS(characterX*2, characterY*2, itemX*2, itemY*2);
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
                if(tmp.x == iX && tmp.y == iY) return count/2;
                for(int j = 0; j<dx.length; j++){
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];
                    if(nx>=0 && nx<120 && ny>=0 && ny<120 && map[ny][nx]>0 && visited[ny][nx] == 0){
                        visited[ny][nx] = 1;
                        q.offer(new Point(nx,ny));
                    }
                }
            }
            count++;
        }
        return -1;
    }
}
