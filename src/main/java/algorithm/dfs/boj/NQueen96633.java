package algorithm.dfs.boj;

import java.util.*;

public class NQueen96633 {
    int[] arr;
    int answer = 0;

    public NQueen96633(int n) {
        this.arr = new int[n];
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();

        NQueen96633 main = new NQueen96633(N);
        main.dfs(0);
        System.out.println(main.answer);
    }

    private void dfs(int d) {
        if (d == arr.length) {
            answer++;
        } else {
            for (int i = 0; i < arr.length; i++) {
                arr[d] = i;
                if (isPossible(d)) {
                    dfs(d + 1);
                }
            }
        }
    }

    private boolean isPossible(int d) {
        for (int i = 0; i < d; i++) {
            if (arr[d] == arr[i]) {
                return false;
            }
            if (Math.abs(d - i) == Math.abs(arr[d] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}
