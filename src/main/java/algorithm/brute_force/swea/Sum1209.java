package algorithm.brute_force.swea;

import java.util.*;
public class Sum1209 {
    static int[][] arr = new int[101][101];

    public static Long solution(int[][] arr){
        Long answer = 0L;
        for(int i = 0; i<100; i++){
            Long row = 0L;
            Long col = 0L;
            for(int j = 0; j<100; j++){
                row += arr[i][j];
                col += arr[j][i];
            }
            answer = Math.max(answer,row);
            answer = Math.max(answer,col);
        }
        Long lCount = 0L;
        Long rCount = 0L;
        for(int i = 0; i<100; i++){
            lCount += arr[i][i];
            rCount += arr[100-i-1][100-i-1];
        }
        answer = Math.max(answer,lCount);
        answer = Math.max(answer,rCount);
        return answer;
    }
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int t = kb.nextInt();
            for(int i = 0; i<100; i++){
                for(int j = 0; j<100; j++){
                    arr[i][j] = kb.nextInt();
                }
            }
            System.out.println("#"+t+" "+solution(arr));
        }
    }
}
