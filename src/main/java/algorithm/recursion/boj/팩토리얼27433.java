package algorithm.recursion.boj;

import java.math.BigInteger;
import java.util.*;
public class 팩토리얼27433 {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        팩토리얼27433 main = new 팩토리얼27433();
        System.out.println(main.solution(N).toString());
    }

    private BigInteger solution(int n) {
        if(n==0) return BigInteger.ONE;
        else return BigInteger.valueOf(n).multiply(solution(n-1));
    }
}
