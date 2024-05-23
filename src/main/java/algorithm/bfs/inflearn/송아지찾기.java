package algorithm.bfs.inflearn;

import java.util.*;
/*
- bfs로 최단거리 구함
- -1, 1, 5를 이동한 거리르 계산해서 큐에 추가
- 큐 길이가 0일 때까지 while문 순회
    1. 큐 길이만큼 for문 순회
    2. poll을 한 값이 송아지 이동 횟수 return
    3. 아니면 poll한 거리에서 -1, 1, 5 연산후 offer
        - 이전에 큐에 추가된 거리였다면 추가 x (시간 제한 걸림)
    4. for문 완료시 이동 횟수 +1
 */

public class 송아지찾기 {

    static int[] dis = {-1, 1, 5};
    static int[] ch;
    static Queue<Integer> q = new LinkedList<>();

    public static int BFS(int S, int E) {
        int answer = 0;
        ch[S] = 1;
        q.offer(S);
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                int tmp = q.poll();
                if (tmp == E) return answer;
                for (int x : dis) {
                    int nx = tmp + x;
                    if (nx >= 1 && nx <= 10000 && ch[nx] == 0) {
                        q.offer(nx);
                        ch[nx] = 1;
                    }
                }
            }
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        ch = new int[10001];
        int S = kb.nextInt();
        int E = kb.nextInt();
        System.out.println(BFS(S, E));
    }
}
