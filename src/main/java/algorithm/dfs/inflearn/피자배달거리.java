package algorithm.dfs.inflearn;
/*
1. 집과 피자집들과의 거리 중 최소값을 해당 집의 피자 배달 거리라고 한다.
2. 집 마다 피자 배달 거리의 합을 도시의 피자 배달 거리라고 한다.
3. 도시의 피자 배달 거리가 최소가 되는 M개의 피자집을 선택
4. 이거는 완전 탐색으로 풀면 안된다. -> a의 집은 a의 피자가 최소이지만 b의 집에서는 최소가 아닐 수 있기 때문
    - 정렬로 해결하려고 하면 효율성에서 걸린다.
5. 조합으로 풀어야 한다.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class 피자배달거리 {
    static int N, M, answer = Integer.MAX_VALUE;
    static int[] ch;
    static ArrayList<Point> hs, p;

    public static void DFS(int L, int n) {
        if (L == M) {
            int sum = 0;
            for (Point house : hs) {
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < ch.length; i++) {
                    if (ch[i] == 1) {
                        int nx = house.x - p.get(i).x;
                        int ny = house.y - p.get(i).y;
                        int dis = Math.abs(nx) + Math.abs(ny);
                        min = Math.min(dis, min);
                    }
                }
                sum += min;
            }
            answer = Math.min(sum, answer);
        }else {
            for (int i = n; i < p.size(); i++) {
                ch[i] = 1;
                DFS(L + 1, i + 1);
                ch[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();
        hs = new ArrayList<>();
        p = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int input = kb.nextInt();
                if (input == 1) hs.add(new Point(j, i));
                if (input == 2) p.add(new Point(j, i));
            }
        }
        ch = new int[p.size()];
        DFS(0, 0);
        System.out.println(answer);
    }
}
