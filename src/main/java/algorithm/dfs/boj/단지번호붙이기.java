package algorithm.dfs.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 단지번호붙이기 {
    int N;
    int[][] map;
    int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};

    public int DFS(int x, int y) {
        int count = 0;
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[ny][nx] == 1) {
                map[ny][nx] = 0;
                count += (1 + DFS(nx, ny));
            }
        }
        return count;
    }

    public ArrayList<Integer> solution() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    map[i][j] = 0;
                    list.add(DFS(j, i)+1);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) throws IOException {
        단지번호붙이기 main = new 단지번호붙이기();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        main.N = Integer.parseInt(br.readLine());
        main.map = new int[main.N][main.N];
        for (int i = 0; i < main.N; i++) {
            String input = br.readLine();
            for (int j = 0; j < main.N; j++) {
                main.map[i][j] = input.charAt(j)-'0';
            }
        }

        ArrayList<Integer> list = main.solution();
        Collections.sort(list);
        System.out.println(list.size());
        for (int n : list) System.out.println(n);
    }
}
