package algorithm.math.boj;

import java.util.*;

public class 최대공약수와최소공배수2609 {
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static int lcm(int a, int b, int gcd) {
        return a * b / gcd;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int a = kb.nextInt();
        int b = kb.nextInt();
        if (b > a) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        int gcd = gcd(a, b);
        int lcm = lcm(a, b, gcd);
        System.out.println(gcd);
        System.out.println(lcm);
    }
}
