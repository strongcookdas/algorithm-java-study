package algorithm.permutation.boj;

import java.util.*;

public class 이전순열10973 {
    int[] pm;
    int[] prevPm;

    public 이전순열10973(int n) {
        this.pm = new int[n];
        this.prevPm = new int[n];
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();

        이전순열10973 main = new 이전순열10973(N);

        for (int i = 0; i < N; i++) {
            main.pm[i] = kb.nextInt();
        }

        boolean flag = main.solution();

        if (flag) {
            for (int n : main.prevPm) {
                System.out.print(n + " ");
            }
        } else {
            System.out.println(-1);
        }
    }

    public boolean solution() {
        int i = this.pm.length - 1;
        while (i > 0 && (this.pm[i - 1] <= this.pm[i])) {
            i--;
        }

        if (i == 0) {
            return false;
        }

        int j = this.pm.length - 1;
        while (j > i - 1 && (this.pm[j] >= this.pm[i - 1])) {
            j--;
        }

        int temp = this.pm[j];
        this.pm[j] = this.pm[i - 1];
        this.pm[i - 1] = temp;

        for (int k = 0; k < i; k++) {
            this.prevPm[k] = this.pm[k];
        }

        for (int k = i; k < this.pm.length; k++) {
            int idx = this.pm.length - (k - i + 1);
            this.prevPm[k] = this.pm[idx];
        }
        return true;

    }

}
