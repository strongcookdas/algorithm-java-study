package algorithm.dfs.boj;

import java.util.*;
import java.io.*;

public class 섬의개수4963 {
    int[][] map;
    int[] dx = {0, 1, 1, 1, 0, -1, -1, -1}, dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        섬의개수4963 main = new 섬의개수4963();

        while (true) {
            String[] inputs = br.readLine().split(" ");
            int w = Integer.parseInt(inputs[0]);
            int h = Integer.parseInt(inputs[1]);
            if (w + h == 0) {
                break;
            }
            main.map = new int[h][w];
            for (int i = 0; i < h; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    main.map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (main.map[i][j] == 1) {
                        count++;
                        main.dfs(j, i);
                    }
                }
            }
            bw.write(count + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private void dfs(int x, int y) {
        map[y][x] = 0;
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < map[0].length && ny >= 0 && ny < map.length && map[ny][nx] == 1) {
                dfs(nx, ny);
            }
        }
    }
}
