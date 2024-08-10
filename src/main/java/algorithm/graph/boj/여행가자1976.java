package algorithm.graph.boj;

import java.util.*;
import java.io.*;

public class 여행가자1976 {
    int[] graph;

    public 여행가자1976(int N) {
        graph = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = i;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        여행가자1976 main = new 여행가자1976(N);

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int input = Integer.parseInt(st.nextToken());
                if (input == 1) {
                    main.union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int temp = main.find(Integer.parseInt(st.nextToken()));
        boolean flag = false;
        for (int i = 1; i < M; i++) {
            int compare = main.find(Integer.parseInt(st.nextToken()));
            if (compare != temp) {
                flag = true;
                break;
            }
        }

        if (flag) {
            bw.write("NO");
        } else {
            bw.write("YES");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private void union(int i, int j) {
        int fa = find(i);
        int fb = find(j);
        if (fa != fb) {
            graph[fa] = fb;
        }
    }

    private int find(int n) {
        if (graph[n] == n) {
            return graph[n];
        }
        return graph[n] = find(graph[n]);
    }
}
