package algorithm.brute_force.programmers;

import java.util.*;

public class 전력망둘로나누기 {
    boolean[][] graph;
    boolean[] ch;

    public int dfs(int root){
        int cnt = 0;
        for(int i =1; i<graph[root].length; i++){
            if(graph[root][i] && !ch[i]){
                ch[i] = true;
                cnt++;
                cnt+=dfs(i);
            }
        }
        return cnt;
    }
    public int solution(int n, int[][] wires) {
        graph = new boolean[n+1][n+1];
        ch = new boolean[n+1];

        for(int[] wire : wires){
            int s = wire[0];
            int d = wire[1];
            graph[s][d] = true;
            graph[d][s] = true;
        }

        int answer = Integer.MAX_VALUE;
        for(int[] wire : wires){
            int s = wire[0];
            int d = wire[1];
            graph[s][d] = false;
            graph[d][s] = false;

            Arrays.fill(ch, false);
            ch[1] = true;
            int count = dfs(1)+1;

            int result = Math.abs(count - (n-count));
            answer = Math.min(answer, result);

            graph[s][d] = true;
            graph[d][s] = true;
        }

        return answer;
    }
}
