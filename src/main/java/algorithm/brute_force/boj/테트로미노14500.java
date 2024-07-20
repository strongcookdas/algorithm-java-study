package algorithm.brute_force.boj;

import java.util.*;
import java.io.*;

public class 테트로미노14500 {
    int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        테트로미노14500 main = new 테트로미노14500();
        main.board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                main.board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(main.solution());

    }

    private int solution() {
        int answer = Integer.MIN_VALUE;

        int[] dx = {0, 1, 2, 3}, dy = {0, 0, 0, 0};

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j <= board[i].length - 4; j++) {
                int sum = 0;
                for (int z = 0; z < dx.length; z++) {
                    sum += board[i + dy[z]][j + dx[z]];
                }
                answer = Math.max(answer, sum);
            }
        }

        for (int i = 0; i <= board.length - 4; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int sum = 0;
                for (int z = 0; z < dx.length; z++) {
                    sum += board[i + dx[z]][j + dy[z]];
                }
                answer = Math.max(answer, sum);
            }
        }

        int[] dx2 = {0, 1, 0, 1}, dy2 = {0, 0, 1, 1};
        for (int i = 0; i <= board.length - 2; i++) {
            for (int j = 0; j <= board[i].length - 2; j++) {
                int sum = 0;
                for (int z = 0; z < dx.length; z++) {
                    sum += board[i + dy2[z]][j + dx2[z]];
                }
                answer = Math.max(answer, sum);
            }
        }

        int[][] dx3 = {{0, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 0}, {1, 0, 0, 0}};
        int[][] dy3 = {{0, 1, 2, 2}, {0, 0, 1, 2}, {0, 1, 2, 2}, {0, 0, 1, 2}};

        for (int i = 0; i <= board.length - 3; i++) {
            for (int j = 0; j <= board[i].length - 2; j++) {
                for (int k = 0; k < dx3.length; k++) {
                    int sum = 0;
                    for (int z = 0; z < dx3[k].length; z++) {
                        sum += board[i + dy3[k][z]][j + dx3[k][z]];
                    }
                    answer = Math.max(answer, sum);
                }
            }
        }

        for (int i = 0; i <= board.length - 2; i++) {
            for (int j = 0; j <= board[i].length - 3; j++) {
                for (int k = 0; k < dx3.length; k++) {
                    int sum = 0;
                    for (int z = 0; z < dx3[k].length; z++) {
                        sum += board[i + dx3[k][z]][j + dy3[k][z]];
                    }
                    answer = Math.max(answer, sum);
                }
            }
        }

        int[][] dx4 = {{0, 0, 1, 1}, {1, 1, 0, 0}, {0, 0, 1, 0}, {1, 1, 0, 1}};
        int[][] dy4 = {{0, 1, 1, 2}, {0, 1, 1, 2}, {0, 1, 1, 2}, {0, 1, 1, 2}};

        for (int i = 0; i <= board.length - 3; i++) {
            for (int j = 0; j <= board[i].length - 2; j++) {
                for (int k = 0; k < dx4.length; k++) {
                    int sum = 0;
                    for (int z = 0; z < dx4[k].length; z++) {
                        sum += board[i + dy4[k][z]][j + dx4[k][z]];
                    }
                    answer = Math.max(answer, sum);
                }
            }
        }

        for (int i = 0; i <= board.length - 2; i++) {
            for (int j = 0; j <= board[i].length - 3; j++) {
                for (int k = 0; k < dx4.length; k++) {
                    int sum = 0;
                    for (int z = 0; z < dx4[k].length; z++) {
                        sum += board[i + dx4[k][z]][j + dy4[k][z]];
                    }
                    answer = Math.max(answer, sum);
                }
            }
        }

        return answer;
    }
}
