package week8.algorithm_1122;

import java.util.Scanner;

public class CodeUp1851 {
    public void solution(int n){
        if (n==0)return;
        System.out.print("*");
        solution(--n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        CodeUp1851 c = new CodeUp1851();
        c.solution(cnt);
    }
}
