package week8.algorithm_1122;

import java.math.BigInteger;
import java.util.Scanner;

public class CodeUp1854 {
    public int solution(String n,int idx){
        if(idx<0) return 0;
        return (n.charAt(idx)-'0')+solution(n,--idx);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.next();
        System.out.println(new CodeUp1854().solution(num,num.length()-1));
    }
}
