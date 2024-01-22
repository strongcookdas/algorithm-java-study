package algorithm.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Bfs {
    public static void main(String[] args) {

        int[][] graph = {{}, {2,3,7}, {1,3,5}, {1,2}, {6,8}, {2}, {4,7,8}, {1,6}, {4,6}};

        boolean[] visit = new boolean[9];

        System.out.println(bfs(1, graph, visit));
    }

    static String bfs(int start, int[][] graph, boolean[] visit) {
        StringBuilder sb = new StringBuilder();

        Queue<Integer> queue = new LinkedList<Integer>();

        queue.offer(start);

        visit[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node + " -> ");
            for (int i = 0; i < graph[node].length; i++) {
                int temp = graph[node][i];
                if (!visit[temp]) {
                    visit   [temp] = true;
                    queue.offer(temp);
                }
            }
        }
        return sb.toString();
    }
}