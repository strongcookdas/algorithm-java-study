package algorithm.dfs.inflearn;

import java.util.*;

public class 경로탐색인접리스트 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] ch;
    static int N, M, answer = 0;

    public static void DFS(int node) {
        if (node == N) answer++;
        else {
            for (int nv : graph.get(node)) {
                if (ch[nv] == 0 ) {
                    ch[nv] = 1;
                    DFS(nv);
                    ch[nv] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        ch = new int[N+1];
        for (int i = 0; i < N + 1; i++) graph.add(new ArrayList<Integer>());
        M = kb.nextInt();
        for (int i = 0; i < M; i++) graph.get(kb.nextInt()).add(kb.nextInt());
        ch[1] = 1;
        DFS(1);
        System.out.println(answer);
    }
}
