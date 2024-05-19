package algorithm.math.boj;

import java.util.*;
public class 이진수3460 {
    public static void solution(int n){
        int c = 0;
        while(n>0){
            if(n%2==1) System.out.print(c+" ");
            n/=2;
            c++;
        }
    }
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int T = kb.nextInt();
        while((T--)>0){
            int n = kb.nextInt();
            solution(n);
        }
    }
}
