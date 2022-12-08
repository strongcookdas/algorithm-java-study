package algorithm.dynamic;

import java.util.Arrays;

public class Fibonacci2 {
    public int solution(int[] arr, int n) {
        for (int i = 1; i <= n; i++) {
            if(i==1||i==2){
                arr[i]=1;
                continue;
            }
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n];
    }

    public static void main(String[] args) {
        Fibonacci2 f = new Fibonacci2();
        int n = 6;
        int[] arr = new int[n + 1];
        System.out.println(f.solution(arr, n));
    }
}
