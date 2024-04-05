package algorithm.two_pointer.boj;

import java.util.*;
import java.io.*;

public class Boj2470두용액 {
    public static void solution(int n, long[] arr) {
        Arrays.sort(arr);
        int lt = 0, rt = arr.length - 1;
        long lp = arr[0], rp = arr[arr.length - 1];
        while (lt < rt) {
            long sum = arr[lt] + arr[rt];
            if (Math.abs(sum) < Math.abs(lp + rp)) {
                lp = arr[lt];
                rp = arr[rt];
            }
            if (sum > 0) rt--;
            else if (sum < 0) lt++;
            else break;
        }
        System.out.println(lp + " " + rp);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        StringTokenizer str = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
        }
        solution(n, arr);

    }
}
