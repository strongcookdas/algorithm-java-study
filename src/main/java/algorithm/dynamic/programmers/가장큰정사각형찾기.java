package algorithm.dynamic.programmers;

public class 가장큰정사각형찾기 {
    public int solution(int[][] board) {
        if (isAllZero(board)) {
            return 0;
        }
        int answer = 1;
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    continue;
                }
                board[i][j] = Math.min(Math.min(board[i - 1][j], board[i][j - 1]), board[i - 1][j - 1]) + 1;
                answer = Math.max(answer, board[i][j]);
            }
        }

        return answer * answer;
    }

    public boolean isAllZero(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;

    }
}