package algorithm.dfs.boj;

//DFS 활용
//512MB 제한이고, 노드의 개수는 1000 이하라 인접행렬로 표현가능

import java.util.*;
import java.io.*;
public class 연결요소의개수11724 {
    int[][] arr;
    int[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M  = Integer.parseInt(st.nextToken());

        연결요소의개수11724 main = new 연결요소의개수11724();
        main.arr = new int[N+1][N+1];
        main.visited = new int[N+1];

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            main.arr[u][v] = 1;
            main.arr[v][u] = 1;
        }

        System.out.println(main.solution());
    }

    private int solution() {
        int answer = 0;
        for(int i = 1; i<visited.length; i++){
            if(visited[i] == 0){
                visited[i] = 1;
                DFS(i);
                answer++;
            }
        }
        return answer;
    }

    private void DFS(int n) {
        for(int i = 1; i<arr[n].length; i++){
            if(arr[n][i]==1 && visited[i] == 0){
                visited[i] = 1;
                DFS(i);
            }
        }
    }
}
