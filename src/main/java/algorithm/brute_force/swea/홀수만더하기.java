package algorithm.brute_force.swea;

import java.util.*;
class 홀수만더하기 {
    static int[][] arr;

    public static void solution(int T){
        for(int i = 0; i<T; i++){
            int sum = 0;
            for(int j = 0; j<10; j++){
                if(arr[i][j]%2==1) sum+=arr[i][j];
            }
            System.out.println("#"+(i+1)+" "+sum);
        }
    }
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        arr=new int[T][10];
        for(int test_case = 0; test_case < T; test_case++)
        {
            for(int i = 0; i<10; i++){
                arr[test_case][i] = sc.nextInt();
            }
        }
        solution(T);
    }
}
