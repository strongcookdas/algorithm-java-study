package algorithm.two_pointer.boj;

import java.util.*;
import java.io.*;

public class Boj3273두수의합 {
    public static int solution(int n, int x, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int lt = 0, rt = arr.length - 1;
        while (lt < rt) {
            if (arr[lt] + arr[rt] > x) rt--;
            else if (arr[lt] + arr[rt] < x) lt++;
            else {
                answer++;
                rt--;
                lt++;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer str = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
        }
        int x = Integer.parseInt(br.readLine());
        System.out.println(solution(n, x, arr));

    }
}
