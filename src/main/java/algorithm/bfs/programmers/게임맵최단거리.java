package algorithm.bfs.programmers;

import java.util.*;

public class 게임맵최단거리 {
    public int bfs(int[][] maps){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] ch = new boolean[maps.length][maps[0].length];
        int[] dx = new int[]{0,0,-1,1};
        int[] dy = new int[]{-1,1,0,0};
        int cnt = 1;

        q.offer(new int[]{0,0});
        ch[0][0] = true;

        while(!q.isEmpty()){
            int n = q.size();
            for(int i =0; i<n; i++){
                int[] tmp = q.poll();
                if(tmp[0] == maps[0].length-1 && tmp[1] == maps.length-1){
                    return cnt;
                }
                for(int j = 0; j<dx.length; j++){
                    int x = tmp[0] + dx[j];
                    int y = tmp[1] + dy[j];
                    if(x>=0 && x<maps[0].length && y>=0 && y<maps.length && maps[y][x] == 1 && !ch[y][x]){
                        q.offer(new int[]{x, y});
                        ch[y][x] = true;
                    }
                }
            }
            cnt++;
        }

        return -1;
    }
    public int solution(int[][] maps) {
        return bfs(maps);
    }
}
