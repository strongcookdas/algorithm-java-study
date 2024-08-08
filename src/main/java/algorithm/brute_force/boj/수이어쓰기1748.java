package algorithm.brute_force.boj;

import java.util.*;

public class 수이어쓰기1748 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String N = kb.nextLine();
        int answer = 0;
        int count = Integer.parseInt(N);
        int mul = 9;
        for (int i = 1; i < N.length(); i++) {
            int temp = i * mul;
            answer += (temp);
            count -= mul;
            mul *= 10;
        }
        answer += (count * N.length());

        System.out.println(answer);
    }
}
