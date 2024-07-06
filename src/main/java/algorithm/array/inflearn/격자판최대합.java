package algorithm.array.inflearn;

import java.util.*;

public class 격자판최대합 {
    public static int solution(int[][] arr) {
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            int row = 0, col = 0;
            for (int j = 0; j < arr[i].length; j++) {
                row += arr[i][j];
                col += arr[j][i];
            }
            answer = Math.max(Math.max(row, col), answer);
        }

        int dg1 = 0, dg2 = 0;
        for (int i = 0; i < arr.length; i++) {
            dg1 += arr[i][i];
            dg2 += arr[i][arr.length - 1 - i];
        }
        answer = Math.max(Math.max(dg1, dg2), answer);

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solution(arr));
    }
}
