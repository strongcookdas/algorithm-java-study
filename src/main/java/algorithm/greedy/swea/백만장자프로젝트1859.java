package algorithm.greedy.swea;

/*
오답 원인
- 정렬을 하지 않아도 O(n)으로 풀 수 있는 문제를 정렬함..
- 맨뒤부터 순회하면 된다.
 */
import java.util.*;

public class 백만장자프로젝트1859 {
    public static long solution(int[] arr){
        long answer = 0;
        int max =Integer.MIN_VALUE;
        for(int i = arr.length-1; i>=0; i--){
            if(arr[i]>max) max = arr[i];
            else answer+= (max-arr[i]);
        }
        return answer;
    }
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            System.out.println("#"+test_case+" "+solution(arr));
        }
    }
}
