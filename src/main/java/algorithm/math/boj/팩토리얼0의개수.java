package algorithm.math.boj;

import java.math.BigInteger;
import java.util.*;

public class 팩토리얼0의개수 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        팩토리얼0의개수 main = new 팩토리얼0의개수();
        System.out.println(main.solution(kb.nextInt()));
    }

    private int solution(int n) {
        BigInteger num = facto(n);
        String s = num.toString();
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '0') {
                break;
            }
            count++;
        }
        return count;
    }

    private BigInteger facto(int i) {
        if (i == 0 || i == 1) {
            return BigInteger.valueOf(1L);
        }
        return BigInteger.valueOf(i).multiply(facto(i - 1));
    }
}
