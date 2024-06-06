package algorithm.dfs.boj;
/**
 * DFS 활용
 * 과정
 * 시작점에서 상하좌우 깊이 탐색하면서 카운트
 * 단, 이미 지나온 알파벳일 경우, 좌표 범위에 벗어난 경우 제외
 */

import java.util.*;
import java.io.*;

public class 알파벳1987 {
    int R, C;
    int[] ch = new int[27], dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
    char[][] arr;

    public int DFS(int x, int y) {
        int max = 0;
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            int count = 0;
            if (nx >= 0 && nx < C && ny >= 0 && ny < R && ch[arr[ny][nx] - 'A'] == 0) {
                ch[arr[ny][nx] - 'A'] = 1;
                count += DFS(nx, ny) + 1;
                ch[arr[ny][nx] - 'A'] = 0;
            }
            max = Math.max(count, max);
        }
        return max;
    }

    public int solution() {
        ch[arr[0][0]-'A']=1;
        return DFS(0, 0)+1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        알파벳1987 main = new 알파벳1987();
        main.R = Integer.parseInt(st.nextToken());
        main.C = Integer.parseInt(st.nextToken());
        main.arr = new char[main.R][main.C];
        for (int i = 0; i < main.R; i++) {
            String inputs = br.readLine();
            for (int j = 0; j < main.C; j++) main.arr[i][j] = inputs.charAt(j);
        }

        System.out.println(main.solution());
    }
}
