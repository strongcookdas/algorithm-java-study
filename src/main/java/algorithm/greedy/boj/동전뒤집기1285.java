package algorithm.greedy.boj;

import java.util.*;

public class 동전뒤집기1285 {
    static int N;
    static char[][] coins;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        coins = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < N; j++) {
                coins[i][j] = line.charAt(j);
            }
        }

        int minFlips = Integer.MAX_VALUE;

        for (int bitmask = 0; bitmask < (1 << N); bitmask++) {
            int flips = 0;
            for (int col = 0; col < N; col++) {
                int tailCount = 0;

                for (int row = 0; row < N; row++) {
                    char current = coins[row][col];
                    if ((bitmask & (1 << row)) != 0) {
                        current = flip(current);
                    }
                    if (current == 'T') {
                        tailCount++;
                    }
                }

                flips += Math.min(tailCount, N - tailCount);
            }
            minFlips = Math.min(minFlips, flips);
        }
        System.out.println(minFlips);
    }

    private static char flip(char c) {
        return c == 'H' ? 'T' : 'H';
    }
}
