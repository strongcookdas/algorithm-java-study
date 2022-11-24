package week8.algorithm_1124;

import java.util.Scanner;

public class CodeUp1860 {
    public void f(int num, int floor){
        if(num>floor) return;
        s(1,num);
        System.out.println();
        f(++num,floor);
    }
    public void s(int num, int repeat){
        if(num>repeat) return;
        System.out.print(num+" ");
        s(++num,repeat);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new CodeUp1860().f(1, sc.nextInt());
    }
}
