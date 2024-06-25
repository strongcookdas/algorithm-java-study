package algorithm.greedy.boj;

import java.util.*;
import java.io.*;

public class ATM11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ATM11399 main = new ATM11399();
        System.out.println(main.solution(arr));
    }

    private int solution(int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int[] sum = new int[arr.length];
        sum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum[i] += arr[i] + sum[i - 1];
        }
        for (int i = 0; i < arr.length; i++) {
            answer += sum[i];
        }
        return answer;
    }
}
