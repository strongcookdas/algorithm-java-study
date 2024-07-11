package algorithm.brute_force.boj;

// swap 후 해당 열과 행을 체크
// 시간 복잡도 50*50*4*50 1억을 넘지 않음

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 사탕게임3085 {
    char[][] board;
    int[] dx = {-1, 0}, dy = {0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        사탕게임3085 main = new 사탕게임3085();
        main.board = new char[N][N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                main.board[i][j] = input.charAt(j);
            }
        }

        bw.write(String.valueOf(main.solution()));
        bw.flush();
        bw.close();
        br.close();
    }

    private int solution() {
        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                answer = Math.max(answer, swap(j, i));
            }
        }
        return answer;
    }

    private int swap(int x, int y) {
        int answer = 0;
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board.length) {
                char tmp = board[y][x];
                board[y][x] = board[ny][nx];
                board[ny][nx] = tmp;

                answer = Math.max(Math.max(compareCandy(x, y, board[y][x]), compareCandy(nx, ny, board[ny][nx])),
                        answer);

                tmp = board[y][x];
                board[y][x] = board[ny][nx];
                board[ny][nx] = tmp;
            }
        }
        return answer;
    }

    private int compareCandy(int x, int y, char c) {
        int row = 1;
        for (int lt = x - 1; lt >= 0; lt--) {
            if (board[y][lt] != c) {
                break;
            }
            row++;
        }
        for (int rt = x + 1; rt < board.length; rt++) {
            if (board[y][rt] != c) {
                break;
            }
            row++;
        }

        int col = 1;
        for (int lt = y - 1; lt >= 0; lt--) {
            if (board[lt][x] != c) {
                break;
            }
            col++;
        }
        for (int rt = y + 1; rt < board.length; rt++) {
            if (board[rt][x] != c) {
                break;
            }
            col++;
        }
        return Math.max(row, col);
    }
}
