package algorithm.dfs.boj;

import java.util.*;

public class 연산자끼워넣기14888 {
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    int[] nums;
    int[] operator;

    public 연산자끼워넣기14888(int N) {
        this.nums = new int[N];
        this.operator = new int[4];
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        연산자끼워넣기14888 main = new 연산자끼워넣기14888(N);
        for (int i = 0; i < N; i++) {
            main.nums[i] = kb.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            main.operator[i] = kb.nextInt();
        }

        main.solution();
        System.out.println(main.max);
        System.out.println(main.min);
    }

    private void solution() {
        dfs(0, nums[0]);
    }

    private void dfs(int L, int total) {
        if (L == nums.length - 1) {
            max = Math.max(total, max);
            min = Math.min(total, min);
        } else {
            for (int i = 0; i < 4; i++) {
                if (operator[i] > 0) {
                    operator[i]--;
                    switch (i) {
                        case 0:
                            dfs(L + 1, total + nums[L + 1]);
                            break;
                        case 1:
                            dfs(L + 1, total - nums[L + 1]);
                            break;
                        case 2:
                            dfs(L + 1, total * nums[L + 1]);
                            break;
                        case 3:
                            dfs(L + 1, total / nums[L + 1]);
                            break;

                    }
                    operator[i]++;
                }
            }
        }
    }
}
