package algorithm.array.inflearn;

import java.util.*;

public class 봉우리 {
    public static int solution(int n, int[][] arr) {
        int answer = 0;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                int y = i, x = j;
                int count = 0;
                for (int k = 0; k < dx.length; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx >= 0 && nx < arr.length && ny >= 0 && ny < arr.length && arr[ny][nx] < arr[y][x]) {
                        count++;
                    }
                }
                if (count == 4) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n + 2][n + 2];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solution(n, arr));
    }
}
