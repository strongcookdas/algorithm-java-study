package algorithm.dfs.inflearn;

import java.util.*;

public class 합이같은부분집합 {
    static int n; // 원소 수
    static int[] arr; // 배열
    static int[] visit; // 인덱스 방문했는지 검사
    static int count = 0; // 서로소 집합끼리 더한 결과가 같으면 +1

    public static void dfs(int d) {
        if (d == n) {
            int c1 = 0;
            int c2 = 0;
            for (int i = 0; i < visit.length; i++) {
                if (visit[i] == 1) c1 += arr[i];
                else c2 += arr[i];
            }
            if (c1 == c2) count++;
        } else {
            visit[d] = 1;
            dfs(d + 1);
            visit[d] = 0;
            dfs(d + 1);
        }
    }

    public static String solution() {
        dfs(0);
        if (count>0) return "YES";
        return "NO";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        visit = new int[n];
        arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = scanner.nextInt();
        System.out.println(solution());
    }
}
