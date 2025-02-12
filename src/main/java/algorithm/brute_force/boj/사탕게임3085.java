package algorithm.brute_force.boj;

import java.io.IOException;
import java.util.Scanner;

public class 사탕게임3085 {
    static char[][] board;
    static int ans=Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        board = new char[n][n];
        for(int i = 0; i<n; i++){
            String str = sc.nextLine();
            for(int j = 0; j<n; j++){
                board[i][j] = str.charAt(j);
            }
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(i+1 < n){
                    swap(i,j,i+1,j);
                    compare(i,j);
                    compare(i+1,j);
                    swap(i,j,i+1,j);
                }

                if(j+1 < n){
                    swap(i,j,i,j+1);
                    compare(i,j);
                    compare(i,j+1);
                    swap(i,j,i,j+1);
                }
            }
        }

        System.out.println(ans);

    }

    public static void swap(int x1, int y1, int x2, int y2){
        char tmp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = tmp;
    }

    public static void compare(int x, int y){
        int row = 1;
        for(int i = 1; i<board.length; i++){
            if(board[x][i] == board[x][i-1]) {
                row++;
            }else {
                ans = Math.max(ans, row);
                row = 1;
            }
        }
        ans = Math.max(ans, row);

        int col = 1;
        for(int i = 1; i<board.length; i++){
            if(board[i][y] == board[i-1][y]) {
                col++;
            }else{
                ans = Math.max(ans, col);
                col = 1;
            }
        }
        ans = Math.max(ans, col);
    }
}
