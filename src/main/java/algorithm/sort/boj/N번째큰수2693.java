package algorithm.sort.boj;

import java.util.*;
public class N번째큰수2693 {
    public static int solution(int[] arr){
        for(int i = 0; i<arr.length; i++){
            for(int j = 1; j<arr.length-i; j++){
                if(arr[j-1]<arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr[2];
    }
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int T = kb.nextInt();
        int N = 10;
        for(int i = 0; i<T; i++){
            int[] arr = new int[N];
            for(int j = 0; j<N; j++) arr[j] = kb.nextInt();
            System.out.println(solution(arr));
        }
    }
}
