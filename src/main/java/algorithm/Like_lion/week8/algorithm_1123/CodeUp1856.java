package algorithm.Like_lion.week8.algorithm_1123;

import java.util.Scanner;

public class CodeUp1856 {
    public int solution (int n){
        if(n==1) return 1;
        else if(n==2) return 2;
        else if(n==3) return 4;
        return solution(n-1)+solution(n-2)+solution(n-3);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(new CodeUp1856().solution(sc.nextInt()));
    }
}
