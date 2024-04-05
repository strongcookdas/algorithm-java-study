package algorithm.stack.programmers;

import java.util.*;
public class 크레인인형뽑기 {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        int n = board.length;
        Stack<Integer> buket = new Stack<>();
        for (int i = 0; i < moves.length; i++) {
            int top = board.length;
            while (top > 1 && board[n - top][moves[i] - 1] == 0) top--;
            int tmp = board[n - top][moves[i] - 1];
            board[n - top][moves[i] - 1] = 0;
            if (tmp == 0) continue;
            if (!buket.isEmpty() && buket.peek() == tmp) {
                buket.pop();
                answer+=2;
            } else buket.push(tmp);
        }
        return answer;
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
