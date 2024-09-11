package algorithm.permutation.boj;

import java.util.*;

public class 부등호2529 {

    long max = Long.MIN_VALUE;
    long min = Long.MAX_VALUE;
    String[] c;
    boolean[] ch = new boolean[10];

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int N = kb.nextInt();
        kb.nextLine();

        String[] c = kb.nextLine().split(" ");

        부등호2529 main = new 부등호2529();

        main.solution(c);
        System.out.println(String.format("%0" + (N + 1) + "d", main.max));
        System.out.println(String.format("%0" + (N + 1) + "d", main.min));
    }

    private void solution(String[] c) {
        this.c = c;
        dfs(0, 0);
    }

    private void dfs(int L, long total) {
        if (L == this.c.length + 1) {
            max = Math.max(total, max);
            min = Math.min(total, min);
        } else {
            for (int i = 0; i < 10; i++) {
                if (!ch[i]) {
                    if (L == 0 || compareNum((int) (total % 10), i, this.c[L - 1])) {
                        ch[i] = true;
                        dfs(L + 1, (total * 10) + i);
                        ch[i] = false;
                    }
                }
            }
        }
    }

    private boolean compareNum(int o1, int o2, String c) {
        if (Objects.equals(c, ">")) {
            return o1 > o2;
        } else {
            return o1 < o2;
        }
    }
}
