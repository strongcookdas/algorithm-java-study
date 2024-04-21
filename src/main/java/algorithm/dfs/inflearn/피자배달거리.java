package algorithm.dfs.inflearn;

import java.util.*;

public class 피자배달거리 {
    static int n, m;
    static ArrayList<Point> hArr = new ArrayList<>();
    static ArrayList<Point> pArr = new ArrayList<>();
    static Point[] combi;
    static int answer = Integer.MAX_VALUE;

    public static void DFS(int L, int s) {
        if (L == m) {
            int sum = 0;
            for (Point p1 : hArr) {
                int min = Integer.MAX_VALUE;
                for (Point p2 : combi) min = Math.min(Math.abs(p2.x - p1.x) + Math.abs(p2.y - p1.y), min);
                sum += min;
            }
            answer = Math.min(answer, sum);
            return;
        }
        for (int i = s; i < pArr.size(); i++) {
            combi[L] = pArr.get(i);
            DFS(L + 1, i + 1);
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        combi = new Point[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = kb.nextInt();
                if (tmp == 1) hArr.add(new Point(j, i));
                if (tmp == 2) pArr.add(new Point(j, i));
            }
        }
        DFS(0, 0);
        System.out.println(answer);
    }
}
