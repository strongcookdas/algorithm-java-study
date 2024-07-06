package algorithm.dynamic.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 카드구매하기16194 {
    int[] cards, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        카드구매하기16194 main = new 카드구매하기16194();
        main.cards = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            main.cards[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(main.solution());
    }

    private int solution() {
        dp = new int[cards.length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < cards.length; i++) {
            int cost = cards[i];
            for (int j = i+1; j <= cards.length; j++) {
                dp[j] = Math.min(dp[j], dp[j - (i+1)] + cost);
            }
        }
        return dp[cards.length];
    }
}
