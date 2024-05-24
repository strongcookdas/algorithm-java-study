package algorithm.dfs.inflearn;

import java.util.*;

public class 경로탐색 {
    static int[][] graph;
    static int[] ch;
    static int N,M, answer = 0;

    public static void DFS(int node){
        if(node == N) {
            answer++;
            return;
        }
        for(int i = 1; i<=N; i++){
            if(graph[node][i]==1&&ch[i]==0){
                ch[i] = 1;
                DFS(i);
                ch[i] = 0;
            }
        }
    }
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();
        graph = new int[N+1][N+1];
        ch = new int[N+1];
        for(int i = 0; i<M; i++){
            int n1 = kb.nextInt();
            int n2 = kb.nextInt();
            graph[n1][n2] = 1;
        }
        ch[1] = 1;
        DFS(1);
        System.out.println(answer);
    }
}
