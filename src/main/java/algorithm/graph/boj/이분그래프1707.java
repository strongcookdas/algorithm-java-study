package algorithm.graph.boj;

import java.util.*;
import java.io.*;

public class 이분그래프1707 {
    ArrayList<ArrayList<Integer>> graph;
    int[] visited;
    boolean flag = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        이분그래프1707 main = new 이분그래프1707();

        while ((N--) > 0) {
            main.graph = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            main.visited = new int[V + 1];
            for (int i = 0; i <= V; i++) {
                main.graph.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                main.graph.get(s).add(d);
                main.graph.get(d).add(s);
            }

            main.flag = true;
            for (int i = 1; i <= V; i++) {
                if (main.visited[i] == 0) {
                    main.visited[i] = 1;
                    main.BFS(i);
                }
            }

            if (main.flag) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private void BFS(int i) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                int tmp = q.poll();
                for (int n : graph.get(tmp)) {
                    if (visited[tmp] == visited[n]) {
                        flag = false;
                        return;
                    }
                    if (visited[n] == 0) {
                        visited[n] = (visited[tmp] == 1) ? 2 : 1;
                        q.offer(n);
                    }
                }
            }
        }
    }
}
