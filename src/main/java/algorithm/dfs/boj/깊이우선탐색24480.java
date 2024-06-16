package algorithm.dfs.boj;

/**
 * DFS 재귀 활용
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 깊이우선탐색24480 {
    int[] visited;
    int order = 1;
    List<List<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][] inputs = new int[M][2];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            inputs[i][0] = Integer.parseInt(st.nextToken());
            inputs[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(inputs, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return b[0] - a[0];
        });
        깊이우선탐색24480 main = new 깊이우선탐색24480();
        main.list = new ArrayList<>();
        main.visited = new int[N];

        for(int i = 0; i<N; i++) main.list.add(new ArrayList<>());

        for(int[] input : inputs) {
            main.list.get(input[0]-1).add(input[1]-1);
            main.list.get(input[1]-1).add(input[0]-1);
        }

        main.solution(R-1);
        for (int answer : main.visited) bw.write(answer + "\n");
        bw.flush();

    }

    private void solution(int r) {
        visited[r] = order++;
        List<Integer> temp = list.get(r);
        for(int num : temp){
            if(visited[num]==0) DFS(1,num);
        }
    }

    private void DFS(int L, int n) {
        visited[n] = order++;
        List<Integer> temp = list.get(n);
        for (int num : temp) {
            if (visited[num] == 0) {
                DFS(L + 1, num);
            }
        }
    }
}
