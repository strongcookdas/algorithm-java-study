package algorithm.Like_lion.week8.algorithm_1124;

import java.util.Scanner;

public class CodeUp1859 {
    public void f(int num, int floor){
        if(num>floor) return;
        s(num);
        System.out.println();
        f(++num,floor);
    }
    public void s(int num){
        if(num==0) return;
        System.out.print("*");
        s(--num);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new CodeUp1859().f(1, sc.nextInt());
    }
}
