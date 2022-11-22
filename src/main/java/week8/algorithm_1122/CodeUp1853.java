package week8.algorithm_1122;

import java.util.Scanner;

public class CodeUp1853 {
    public int solution(int n){
        if(n==0) return 0;
        return n+solution(--n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(new CodeUp1853().solution(num));
    }
}
