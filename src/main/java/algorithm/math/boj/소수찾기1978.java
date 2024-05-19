package algorithm.math.boj;

import java.util.*;

public class 소수찾기1978 {

    public static boolean isPrime(int n) {
        if (n == 1 || n == 0) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static int solution(int[] arr) {
        int answer = 0;
        for (int n : arr) {
            if (isPrime(n)) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = kb.nextInt();
        System.out.println(solution(arr));
    }
}
