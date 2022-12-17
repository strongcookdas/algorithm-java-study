package algorithm.Like_lion.week8.algorithm_1124;

import java.util.Scanner;

public class CodeUp1904 {
    public void solution(int num, int repeat){
        if(num>repeat) return;
        if(num%2!=0)
            System.out.print(num+" ");
        solution(++num,repeat);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new CodeUp1904().solution(sc.nextInt(),sc.nextInt());
    }
}
