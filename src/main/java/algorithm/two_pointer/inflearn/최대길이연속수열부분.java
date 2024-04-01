package algorithm.two_pointer.inflearn;

import java.util.*;

public class 최대길이연속수열부분 {//*
    public static int solution(int n, int k, int[] arr) {
        int answer = 0;
        ArrayList<Integer> tmp = new ArrayList<>();
        int lt = 0;
        int count = 0;
        for (int rt = 0; rt < n; rt++) {
            if (arr[rt] == 1) count++;
            else {
                if (k > 0) {
                    count++;
                    k--;
                } else {
                    answer = Math.max(answer, count);
                    count = (rt) - tmp.get(lt++);
                }
                tmp.add(rt);
            }
        }
        answer = Math.max(answer, count);
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
        System.out.println(solution(n, k, arr));
    }
}
