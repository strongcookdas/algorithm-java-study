package algorithm.sort.inflearn;
/**
 * 캐시 히트일 경우
 * 맨 앞으로 이동 후 나머지는 뒤로
 * 캐시 미스일 경우
 * 맨 앞에 추가 후 나머지 뒤로 이동
 */

import java.util.*;

public class LRU {
    public static int[] solution(int n, int m, int[] arr) {
        int[] answer = new int[n];
        for (int num : arr) {
            int hit;
            for (hit = 0; hit < n; hit++) {
                if (answer[hit] == num || answer[hit] == 0) break;
            }
            if (hit == answer.length) answer[--hit] = num;
            else if (answer[hit] != num) answer[hit] = num;
            for (int i = hit; i > 0; i--) {
                int temp = answer[i - 1];
                answer[i - 1] = answer[i];
                answer[i] = temp;
            }
        }
        return answer;
    }

    public static void main(String[] argus) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) arr[i] = scanner.nextInt();
        for (int i : solution(n, m, arr)) System.out.print(i + " ");
    }
}
