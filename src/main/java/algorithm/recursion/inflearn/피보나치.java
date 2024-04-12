package algorithm.recursion.inflearn;

public class 피보나치 {
    //시간 효율성을 위해서는 재귀로만 풀면 x (메모이제이션 활용)
    static int[] fibo;
    public static int DFS(int n) {
        if (n == 1) return fibo[n] = 1;
        else if (n == 2) return fibo[n] = 1;
        else if (fibo[n]!=0) return fibo[n];
        else return fibo[n] = DFS(n - 2) + DFS(n - 1);
    }

    public static void main(String[] args) {
        int n = 45;
        fibo = new int[n+1];
        DFS(n);
        for (int i = 1; i <= n; i++) System.out.println(fibo[i]);
    }
}
