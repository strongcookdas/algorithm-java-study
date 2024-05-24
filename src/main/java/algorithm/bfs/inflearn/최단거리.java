package algorithm.bfs.inflearn;

import java.util.*;

public class 최단거리 {
    static ArrayList<ArrayList<Integer>> graph;
    static Queue<Integer> Q;
    static int[] ch, dis;
    static int N, M;

    public static void BFS(int v) {
        ch[v] = 1;
        dis[v] = 0;
        Q = new LinkedList<>();
        Q.offer(v);
        while (!Q.isEmpty()) {
            int cv = Q.poll();
            for (int nv : graph.get(cv)) {
                if(ch[nv] == 0){
                    ch[nv] = 1;
                    Q.offer(nv);
                    dis[nv] = dis[cv] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        ch = new int[N+1];
        dis = new int[N+1];
        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) graph.add(new ArrayList<>());
        M = kb.nextInt();
        for (int i = 0; i < M; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph.get(a).add(b);
        }
        BFS(1);
        for (int i = 2; i<=N; i++) {
            System.out.println(i + " : " + dis[i]);
        }
    }
}
