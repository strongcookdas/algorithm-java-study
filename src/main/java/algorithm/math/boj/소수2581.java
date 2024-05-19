package algorithm.math.boj;

import java.util.*;

public class 소수2581 {
    static int[] arr;

    public static boolean isPrime(int n) {
        if (n == 1 || n == 0 || arr[n] == 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void solution(int m, int n) {
        arr = new int[n + 1];
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                for (int j = i * 2; j <= n; j+=i) arr[j] = 1;
                if (i >= m) {
                    sum += i;
                    min = Math.min(min, i);
                }
            }
        }
        if(sum==0){
            System.out.println(-1);
            return;
        }
        System.out.println(sum);
        System.out.println(min);
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int m = kb.nextInt();
        int n = kb.nextInt();
        solution(m, n);
    }
}
