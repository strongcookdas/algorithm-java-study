package algorithm.dynamic.programmers;

// 다이나믹 프로그래밍 활용
// dp[i][j] = dp[i-1][k] + land[i][j]
// dp에는 i번째 행의 j를 마지막으로 밟았을 때의 최댓값을 구한 배열

public class 땅따먹기 {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][4];
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (i == 0) {
                    dp[i][j] = land[i][j];
                } else {
                    for (int k = 0; k < 4; k++) {
                        if (k == j) {
                            continue;
                        }
                        dp[i][j] = Math.max(dp[i][j], land[i][j] + dp[i - 1][k]);
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < 4; i++) {
            answer = Math.max(dp[land.length - 1][i], answer);
        }
        return answer;
    }
}
