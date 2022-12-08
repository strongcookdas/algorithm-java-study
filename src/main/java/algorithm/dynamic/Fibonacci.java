package algorithm.dynamic;

public class Fibonacci {
    public int solution(int[] arr, int n) {
        if (n == 1 || n == 2) return 1;
        if (arr[n] != 0) return arr[n];
        return arr[n] = solution(arr, n - 1) + solution(arr, n - 2);
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        int n = 7;
        int[] arr = new int[n + 1];
        System.out.println(f.solution(arr, n));
    }
}
