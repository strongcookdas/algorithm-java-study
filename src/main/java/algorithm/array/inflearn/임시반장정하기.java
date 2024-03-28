package algorithm.array.inflearn;

import java.util.*;

public class 임시반장정하기 {
    public static int solution(int n, int[][] arr) {
        int answer = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int[] flag = new int[n];
            int count = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 5; k++) {
                    if (arr[i][k] == arr[j][k]) {
                        if (flag[j] == 1) continue;
                        flag[j] = 1;
                        count++;
                    }
                }
            }
            if (max < count) {
                max = count;
                answer = i;
            }
        }
        return answer+1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solution(n, arr));
    }
}
