package algorithm.binary_search.inflearn;

import java.util.*;

public class 이분검색 {
    public static int solution(int n, int m, int[] arr) {
        Arrays.sort(arr);
        int lt = 0, rt = arr.length - 1;
        int answer = (lt + rt) / 2;
        while (arr[answer] != m) {
            if (arr[answer] > m) rt = answer;
            else lt = answer;
            answer = (lt + rt) / 2;
        }
        return answer+1;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = kb.nextInt();
        System.out.println(solution(n, m, arr));
    }
}
