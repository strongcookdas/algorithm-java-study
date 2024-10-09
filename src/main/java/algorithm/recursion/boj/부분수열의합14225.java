package algorithm.recursion.boj;

import java.util.*;

public class 부분수열의합14225 {
    int[] nums;
    boolean[] ch;

    public 부분수열의합14225(int N) {
        this.ch = new boolean[2000001];
        this.nums = new int[N];
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();

        부분수열의합14225 main = new 부분수열의합14225(N);
        for (int i = 0; i < N; i++) {
            main.nums[i] = kb.nextInt();
        }

        System.out.println(main.solution());
    }

    private int solution() {
        dfs(0, 0, 0);
        for (int i = 1; i < this.ch.length; i++) {
            if (!this.ch[i]) {
                return i;
            }
        }
        return 0;
    }

    private void dfs(int L, int sum, int root) {
        for (int i = root; i < this.nums.length; i++) {
            sum += this.nums[i];
            this.ch[sum] = true;
            dfs(L + 1, sum, i+1);
            sum -= this.nums[i];
        }
    }
}
