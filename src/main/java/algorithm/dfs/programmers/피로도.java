package algorithm.dfs.programmers;

public class 피로도 {
    int[] visited;
    int answer = 0;

    public int solution(int k, int[][] dungeons) {
        int answer = 0;
        visited = new int[dungeons.length];

        answer = DFS(0, k, dungeons, 0);

        return answer;
    }

    private int DFS(int L, int k, int[][] dungeons, int count){
        if(L == visited.length){
            answer = Math.max(answer,count);
        }else{
            for(int i = 0; i<visited.length; i++){
                if(visited[i]==0){
                    visited[i] = 1;
                    if(k>=dungeons[i][0])DFS(L+1, k-dungeons[i][1], dungeons, count+1);
                    else DFS(L+1, k, dungeons, count);
                    visited[i] = 0;
                }
            }
        }
        return answer;
    }
}
