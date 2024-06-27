package algorithm.graph.boj;

import java.io.*;
import java.util.*;

public class 집합의표현1717 {
    int[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        집합의표현1717 main = new 집합의표현1717();
        main.graph = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            main.graph[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int operator = Integer.parseInt(st.nextToken());
            int operand1 = Integer.parseInt(st.nextToken());
            int operand2 = Integer.parseInt(st.nextToken());
            if (operator == 0) {
                main.union(operand1, operand2);
            } else {
                if (main.find(operand1) == main.find(operand2)) {
                    bw.write("YES\n");
                } else {
                    bw.write("NO\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private void union(int operand1, int operand2) {
        int fa = find(operand1);
        int fb = find(operand2);
        if (fa != fb) {
            graph[fa] = fb;
        }
    }

    private int find(int num) {
        if (graph[num] == num) {
            return num;
        } else {
            return graph[num] = find(graph[num]);
        }
    }
}
