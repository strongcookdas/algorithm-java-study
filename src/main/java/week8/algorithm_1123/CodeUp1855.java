package week8.algorithm_1123;

import java.util.Scanner;

public class CodeUp1855 {
    public int solution (int n){
        if(n<=2) return 1;
        return solution(n-1)+solution(n-2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(new CodeUp1855().solution(sc.nextInt()));
    }
}
