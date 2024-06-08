package algorithm.stack_queue.programmers;

import java.util.*;

public class 크레인인형뽑기 {
    public static int solution(int[][] board, int[] move) {
        int count = 0;
        Stack<Integer> buket = new Stack<>();
        for (int m : move) {
            int idx = 0;
            int temp = 0;
            while (idx != board.length && (temp = board[idx][m - 1]) == 0) ++idx;
            if (idx < board.length) board[idx][m - 1] = 0;
            if (temp != 0 && !buket.isEmpty() && buket.peek() == temp) {
                count += 2;
                buket.pop();
            } else buket.push(temp);
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = scanner.nextInt();
            }
        }
        int m = scanner.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = scanner.nextInt();
        }
        System.out.println(solution(board, moves));
    }
}
