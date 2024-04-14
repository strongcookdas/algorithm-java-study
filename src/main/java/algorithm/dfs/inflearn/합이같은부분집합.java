package algorithm.dfs.inflearn;

import java.util.*;

public class 합이같은부분집합 {
    static String answer = "NO";
    static int n, total = 0;
    static boolean flag = false;

    public static void dfs(int L, int sum, int[] arr) {
        if(flag) return; //서로소 집합의 합이 이미 같을 때 스택에 쌓인 함수들 return;
        if(sum>total/2) return; // 이건 깊이 우선 탐색 sum이 totla의 절반이 넘어가면 더 탐색해봤자 무의미
        if(L == n){
            if((total-sum)==sum){
                answer="YES";
                flag = true;
            }
        }else{
            dfs(L+1, sum+arr[L], arr);
            dfs(L+1, sum,arr);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            total += arr[i];
        }
        dfs(0,0,arr);
        System.out.println(answer);
    }
}
