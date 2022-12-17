package algorithm.Like_lion.week8.algorithm_1123;

import java.util.Scanner;

public class Fibonacci {
    public int solution (int n){
        if(n<=2) return 1;
        int ans=0;
        int a = 1;
        int b = 1;
        while((n--)>2){
            ans=a+b;
            int temp = a;
            a = ans;
            b = temp;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(new Fibonacci().solution(sc.nextInt()));
    }
}
