package algorithm.recursion.swea;

import java.util.Scanner;

public class 거듭제곱1217 {
    public static int solution(int n, int m) {
        if(m==0) return 1;
        return n*solution(n,m-1);
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int T = 10;
        for(int t=0; t<T; t++) {
            int temp = kb.nextInt();
            int n = kb.nextInt();
            int m = kb.nextInt();
            System.out.println("#"+temp+" "+solution(n,m));
        }
    }
}
