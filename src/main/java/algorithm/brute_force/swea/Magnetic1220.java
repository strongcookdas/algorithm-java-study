package algorithm.brute_force.swea;

import java.util.*;

public class Magnetic1220 {

    public static int solution(int[][] arr) {
        int answer = 0;
        for(int i = 0; i<100; i++) {
            boolean check = false;
            for(int j = 0; j<100; j++) {
                if(arr[j][i]==1) check = true;
                if(arr[j][i]==2 && check) {
                    check = false;
                    answer++;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int T = 10;
        int[][] arr = new int[100][100];
        for(int t=1; t<=T; t++) {
            int n = kb.nextInt();
            for(int i = 0; i<100; i++) {
                for(int j = 0; j<100; j++) {
                    arr[i][j] = kb.nextInt();
                }
            }
            System.out.println("#"+t+" "+solution(arr));
        }
    }
}
