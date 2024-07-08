package algorithm.dfs.boj;

// A-B-C-D-E 와 같이 depth가 5인 친구 관계가 있는지 확인하는 문제

import java.io.*;
import java.util.*;

public class ABCDE13023 {

    int[] ch;
    boolean flag = false;
    ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ABCDE13023 main = new ABCDE13023();
        main.ch = new int[N];
        main.graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            main.graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            main.graph.get(a).add(b);
            main.graph.get(b).add(a);
        }

        main.solution();
        System.out.println((main.flag) ? 1 : 0);
    }

    private void solution() {
        for (int i = 0; i < ch.length; i++) {
            if (flag) {
                return;
            }
            ch[i] = 1;
            DFS(0, i);
            ch[i] = 0;
        }
    }

    private void DFS(int L, int V) {
        if (flag) {
            return;
        }
        if (L == 4) {
            flag = true;
            return;
        }
        for (int n : graph.get(V)) {
            if (ch[n] == 0) {
                ch[n] = 1;
                DFS(L + 1, n);
                ch[n] = 0;
            }
        }
    }
}
