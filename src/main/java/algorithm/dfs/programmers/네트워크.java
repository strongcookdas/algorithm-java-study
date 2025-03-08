package algorithm.dfs.programmers;

public class 네트워크 {
    boolean[] ch;

    public void dfs(int root, int[][] computers){
        for(int i = 0; i<computers.length; i++){
            if(computers[root][i]==1 && !ch[i]){
                ch[i] = true;
                dfs(i, computers);
            }
        }
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        ch = new boolean[n];

        for(int i = 0; i<n; i++){
            if(!ch[i]){
                answer++;
                ch[i] = true;
                dfs(i, computers);
            }
        }
        return answer;
    }
}