package algorithm.recursion.inflearn;

import java.util.*;

public class 피보나치 {
    static int[] fibo;
    public static int solution(int n){
        if(n==0||n==1) return fibo[n] = 1;
        if(fibo[n]!=0) return fibo[n];
        return fibo[n] = solution(n-2) + solution(n-1);
    }
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        fibo = new int[n];
        solution(n-1);
        for(int v : fibo){
            System.out.print(v+" ");
        }
    }
}
