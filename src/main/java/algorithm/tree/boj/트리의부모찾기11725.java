package algorithm.tree.boj;

import java.io.*;
import java.util.*;

public class 트리의부모찾기11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(p).add(c);
            graph.get(c).add(p);
        }

        트리의부모찾기11725 main = new 트리의부모찾기11725();
        int[] result = main.solution(graph);

        for (int i = 2; i <= N; i++) {
            bw.write(String.valueOf(result[i]) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }

    private int[] solution(ArrayList<ArrayList<Integer>> graph) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        int[] result = new int[graph.size()];
        result[1] = -1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int p = q.poll();
                for (int c : graph.get(p)) {
                    if (result[c] == 0) {
                        result[c] = p;
                        q.offer(c);
                    }
                }
            }
        }
        return result;
    }
}
