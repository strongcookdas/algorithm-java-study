package algorithm.dynamic.inflearn;
/*
문제는 1번만 풀 수 있다는 점을 고려해야 한다.
 */

import java.util.*;

class Problem {
    int score;
    int time;

    public Problem(int score, int time) {
        this.score = score;
        this.time = time;
    }
}

public class 최대점수구하기 {
    static int n, m;
    static int[] dy;

    public static int solution(Problem[] arr) {
        Arrays.fill(dy, 0);
        for (int i = 0; i < arr.length; i++) {
            int time = arr[i].time;
            int score = arr[i].score;
            for (int j = dy.length - 1; j >= time; j--) {
                dy[j] = Math.max(dy[j], dy[j - time] + score);
            }
        }
        return dy[m];
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        Problem[] arr = new Problem[n];
        m = kb.nextInt();
        dy = new int[m + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = new Problem(kb.nextInt(), kb.nextInt());
        }
        System.out.println(solution(arr));
    }
}
