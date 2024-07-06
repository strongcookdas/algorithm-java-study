package algorithm.dynamic.inflearn;

import java.util.*;

public class 가장높은탑쌓기 {

    static class Brick {
        int width;
        int height;
        int weight;

        public Brick(int width, int height, int weight) {
            this.width = width;
            this.height = height;
            this.weight = weight;
        }
    }

    static Brick[] inputs;
    static int[] dp;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        dp = new int[N];
        inputs = new Brick[N];

        for (int i = 0; i < N; i++) {
            inputs[i] = new Brick(kb.nextInt(), kb.nextInt(), kb.nextInt());
        }

        solution();
        System.out.println(answer);
    }

    private static void solution() {
        Arrays.sort(inputs, (a, b) -> b.width - a.width);
        for (int i = 0; i < inputs.length; i++) {
            dp[i] = inputs[i].height;
            for (int j = 0; j < i; j++) {
                if (inputs[i].weight <= inputs[j].weight) {
                    dp[i] = Math.max(dp[i], inputs[i].height + dp[j]);
                }
            }
            answer = Math.max(answer, dp[i]);
        }
    }
}
