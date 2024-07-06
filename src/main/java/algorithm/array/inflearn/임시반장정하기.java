package algorithm.array.inflearn;

import java.util.*;

public class 임시반장정하기 {
    public static int solution(int n, int[][] arr) {
        int answer = 0, max = Integer.MIN_VALUE;
        int[] ch = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            Arrays.fill(ch, 0);
            for (int j = 0; j < 5; j++) {
                for (int z = 0; z < n; z++) {
                    if (z == i) {
                        continue;
                    }
                    if (arr[i][j] == arr[z][j] && ch[z] == 0) {
                        count++;
                        ch[z] = 1;
                    }
                }
            }
            if (count > max) {
                max = count;
                answer = i + 1;
            }
        }
        return answer;
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
