package algorithm.two_pointer.inflearn;

import java.util.*;

public class 공통원소구하기 {
    public ArrayList<Integer> solution(int[] arr1, int[] arr2) {
        ArrayList<Integer> list = new ArrayList<>();
        int t1 = 0, t2 = 0;
        while (t1 < arr1.length && t2 < arr2.length) {
            if (arr1[t1] == arr2[t2]) {
                list.add(arr1[t1]);
                t1++;
                t2++;
            } else if (arr1[t1] < arr2[t2]) t1++;
            else t2++;
        }
        return list;
    }

    public static void main(String[] args) {
        공통원소구하기 main = new 공통원소구하기();
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int[] arr1 = new int[N];
        for (int i = 0; i < N; i++) arr1[i] = kb.nextInt();
        int M = kb.nextInt();
        int[] arr2 = new int[M];
        for (int i = 0; i < M; i++) arr2[i] = kb.nextInt();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int n : main.solution(arr1, arr2)) System.out.print(n + " ");
    }
}
