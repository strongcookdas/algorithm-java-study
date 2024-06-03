package algorithm.dfs.programmers;
/*
- DFS 활용
- 과정
    - 방문 확인 배열 생성
    - 방문 확인 배열 체크 후 첫번째 노드부터 깊이 탐색 ( 체크 배열이 1이면 건너뛰기 아니면 answer +1 하고 깊이탐색)
    - for문으로 이어진 노드가 있는지 확인
        - 있다면 방문 확인 배열 체크 후 해당 노드의 연결된 다른 노드 탐색
 */
public class 네트워크 {
    int[] ch;

    public void DFS(int node, int n, int[][] computers) {
        for (int i = 0; i < n; i++) {
            if (computers[node][i] == 1 && ch[i] == 0) {
                ch[i] = 1;
                DFS(i, n, computers);
            }
        }
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        ch = new int[n];
        for (int i = 0; i < n; i++) {
            if (ch[i] == 1) continue;
            answer++;
            ch[i] = 1;
            DFS(i, n, computers);
        }
        return answer;
    }
}