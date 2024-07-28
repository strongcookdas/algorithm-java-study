package algorithm.bfs.boj;

import java.util.*;
import java.io.*;

public class 나이트의이동7562 {
    boolean[][] visited;
    int[] dx = {-1, 1, 2, 2, 1, -1, -2, -2}, dy = {-2, -2, -1, 1, 2, 2, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        나이트의이동7562 main = new 나이트의이동7562();

        int T = Integer.parseInt(br.readLine());
        while ((T--) > 0) {
            int N = Integer.parseInt(br.readLine());
            main.visited = new boolean[N][N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] start = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            st = new StringTokenizer(br.readLine());
            int[] end = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            bw.write(String.valueOf(main.bfs(start, end)));
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private int bfs(int[] start, int[] end) {
        Queue<Integer[]> q = new LinkedList<>();
        q.offer(new Integer[]{start[0], start[1]});
        visited[start[1]][start[0]] = true;
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Integer[] position = q.poll();
                if (position[0] == end[0] && position[1] == end[1]) {
                    return count;
                }
                for (int j = 0; j < dx.length; j++) {
                    int nx = position[0] + dx[j];
                    int ny = position[1] + dy[j];
                    if (nx >= 0 && nx < visited.length && ny >= 0 && ny < visited.length && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        q.offer(new Integer[]{nx, ny});
                    }
                }
            }
            count++;
        }
        return count;
    }
}
