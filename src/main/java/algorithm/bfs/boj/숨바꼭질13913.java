package algorithm.bfs.boj;

import java.util.*;
import java.io.*;

public class 숨바꼭질13913 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        숨바꼭질13913 main = new 숨바꼭질13913();
        ArrayList<Integer> answer = main.bfs(N, K);
        bw.write(answer.size() - 1 + "\n");
        for (int i = answer.size() - 1; i >= 0; i--) {
            bw.write(answer.get(i) + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private ArrayList<Integer> bfs(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        int[] visited = new int[100001];
        Arrays.fill(visited, -1);
        q.offer(n);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int tmp = q.poll();
                if (tmp == k) {
                    answer.add(tmp);
                    int key = tmp;
                    int value;
                    while ((value = visited[key]) != -1) {
                        answer.add(value);
                        key = value;
                    }
                    return answer;
                }
                int[] move = {tmp - 1, tmp + 1, tmp * 2};
                for (int m : move) {
                    if (m != n && m >= 0 && m <= 100000 && visited[m] == -1) {
                        visited[m] = tmp;
                        q.offer(m);
                    }
                }
            }
        }
        return answer;
    }
}
