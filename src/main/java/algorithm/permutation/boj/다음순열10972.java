package algorithm.permutation.boj;

import java.util.*;

public class 다음순열10972 {
    int[] pm;
    int[] nextPm;
    boolean[] num;
    boolean[] ch;
    boolean flag;

    public 다음순열10972(int N) {
        this.pm = new int[N];
        this.nextPm = new int[N];
        this.num = new boolean[N + 1];
        this.ch = new boolean[N + 1];
        this.flag = false;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();

        다음순열10972 main = new 다음순열10972(N);
        for (int i = 0; i < N; i++) {
            main.pm[i] = kb.nextInt();
        }

        main.solution(0);
        if (!main.flag) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < main.nextPm.length; i++) {
                System.out.print(main.nextPm[i] + " ");
            }
        }
    }

    private void solution(int L) {
        if (this.flag) {
            return;
        }
        if (L == pm.length) {
            for (int i = 0; i < pm.length; i++) {
                if (pm[i] != nextPm[i]) {
                    this.flag = true;
                    break;
                }
            }
        } else {
            for (int i = 1; i <= pm.length; i++) {
                if (pm[L] == i) {
                    ch[L] = true;
                }
                if (ch[L]) {
                    if (!num[i]) {
                        num[i] = true;
                        nextPm[L] = i;
                        solution(L + 1);
                        if (this.flag) {
                            break;
                        }
                        num[i] = false;
                    }
                }
            }
        }
    }
}
