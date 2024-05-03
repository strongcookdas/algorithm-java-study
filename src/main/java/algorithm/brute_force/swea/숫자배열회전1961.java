package algorithm.brute_force.swea;
/*
- 오답 원인
- 앞자리가 0일경우도 출력 String으로 연산해야함
 */
import java.util.Scanner;

public class 숫자배열회전1961 {
    public static void solution(int n,int[][] arr, String[][] answer){
        for(int i = 0; i<n; i++){
            String tmp = "";
            for(int j = n-1; j>=0; j--){
                tmp += String.valueOf(arr[j][i]);
            }
            answer[i][0] = tmp;
        }
        for(int i = n-1; i>=0; i--){
            String tmp = "";
            for(int j = n-1; j>=0; j--){
                tmp +=  String.valueOf(arr[i][j]);
            }
            answer[n-i-1][1] = tmp;
        }
        for(int i = n-1; i>=0; i--){
            String tmp = "";
            for(int j = 0; j<n; j++){
                tmp +=  String.valueOf(arr[j][i]);
            }
            answer[n-i-1][2] = tmp;
        }
    }
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            String[][] answer = new String[n][3];
            for(int i = 0; i<n; i++)
                for(int j = 0; j<n; j++)
                    arr[i][j] = sc.nextInt();
            solution(n,arr,answer);
            System.out.println("#"+test_case);
            for(int i = 0; i<n; i++){
                for(int j = 0; j<3; j++)
                    System.out.print(answer[i][j]+" ");
                System.out.println();
            }
        }
    }
}
