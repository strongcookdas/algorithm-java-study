package algorithm.array.inflearn;

import java.util.*;

public class 멘토링 {
    public static int solution(int n, int m, int[][] arr) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            boolean[] flag = new boolean[n];
            for (int j = 0; j < m; j++) {
                boolean check = false;
                for (int k = 0; k < n; k++) {
                    if (arr[j][k] == (i + 1)) check = true;
                    else {
                        if (check) {
                            if (j == 0) flag[arr[j][k] - 1] = true;
                        } else {
                            if (j != 0) flag[arr[j][k] - 1] = false;
                        }
                    }
                }
            }
            for (int k = 0; k < n; k++) {
                if (flag[k]) answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solution(n, m, arr));
    }
}
