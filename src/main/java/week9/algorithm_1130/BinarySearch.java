package week9.algorithm_1130;

import java.util.Scanner;

public class BinarySearch {
    public int solution(int a, int b) {
        if (a > b) return solution(a / 2, b) + 1;
        else if (b > a) return solution(a, b / 2) + 1;
        else return 0;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        Scanner sc = new Scanner(System.in);
        int ans = bs.solution(sc.nextInt(), sc.nextInt());
        System.out.println(ans);
    }
}
