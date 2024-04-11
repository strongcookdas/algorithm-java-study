package algorithm.sort.inflearn;

import java.util.*;

public class LRU { // time : 10m
    public static ArrayList<Integer> solution(int n, int m, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i : arr) {
            int idx = answer.indexOf(i);
            if (idx != -1) {
                answer.remove(idx);
                answer.add(0, i);
            } else {
                if (answer.size() == n) answer.remove(answer.size() - 1);
                answer.add(0, i);
            }
        }
        return answer;
    }

    public static void main(String[] argus) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) arr[i] = scanner.nextInt();
        for (int i : solution(n, m, arr)) System.out.print(i + " ");
    }
}
