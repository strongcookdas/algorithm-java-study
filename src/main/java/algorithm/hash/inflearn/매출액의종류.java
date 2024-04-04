package algorithm.hash.inflearn;

import java.util.*;

public class 매출액의종류 {
    public static ArrayList<Integer> solution(int n, int k, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int lt = 0;
        for (int rt = 0; rt < n; rt++) {
            if (rt < k) map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            else {
                if (rt == k) answer.add(map.size());
                if (map.get(arr[lt]) == 1) map.remove(arr[lt++]);
                else map.put(arr[lt], map.get(arr[lt++]) - 1);
                map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
                answer.add(map.size());
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        for (Integer i : solution(n, k, arr)) {
            System.out.print(i + " ");
        }
    }
}
