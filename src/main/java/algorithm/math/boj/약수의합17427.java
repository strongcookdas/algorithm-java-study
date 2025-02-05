package algorithm.math.boj;

import java.util.Scanner;

public class 약수의합17427 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        long g = 0L;
        for(int i = 1; i<=n; i++){
            g += ((long) i *(n/i));
        }

        System.out.println(g);
    }
}
