package algorithm.dynamic;

import java.util.Arrays;

class Pair{
    int left;
    int right;

    public Pair(int left, int right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "(" + left + "," + right +
                ')';
    }
}

public class OptimalStrategy {

    public static void main(String[] args) {
        int[] coins = {2,7,40,19};

        Pair[][] dp = new Pair[coins.length][coins.length];

        for (int i = 0; i < coins.length; i++) {
            dp[i][i] = new Pair(coins[i],0);
        }

        for (int i = 0; i < coins.length-1; i++) {
            int left = Math.max(coins[i], coins[i+1]);
            int right = Math.min(coins[i], coins[i+1]);
            dp[i][i+1] = new Pair(left,right);
        }

        for (int i = 0; i < coins.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
    }
}
