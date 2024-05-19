package algorithm.brute_force.boj;

import java.util.*;

public class 쉽게푸는문제1292 {
    public static int solution(int a, int b) {
        int cnt = 1;
        int sum = 0;
        int n = 1;
        while (cnt <= b) {
            for (int i = 0; i < n; i++) {
                if (cnt >= a && cnt<= b) sum += n;
                cnt++;
            }
            n++;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int a = kb.nextInt();
        int b = kb.nextInt();
        System.out.println(solution(a,b));
    }
}
