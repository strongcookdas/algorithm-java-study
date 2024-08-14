package algorithm.binary_search.boj;

import java.util.*;
import java.io.*;

public class 숫자카드10816 {
    int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        숫자카드10816 main = new 숫자카드10816();
        main.arr = new int[N];

        for (int i = 0; i < N; i++) {
            main.arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(main.arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int input = Integer.parseInt(st.nextToken());
            int output = main.solution(input);
            bw.write(String.valueOf(output) + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private int solution(int input) {
        int lt = 0, rt = arr.length;
        while (lt < rt) {
            int mid = (lt + rt) / 2;
            if (arr[mid] >= input) {
                rt = mid;
            } else {
                lt = mid + 1;
            }
        }
        int low = lt;
        lt = 0;
        rt = arr.length;
        while (lt < rt) {
            int mid = (lt + rt) / 2;
            if (arr[mid] > input) {
                rt = mid;
            } else {
                lt = mid + 1;
            }
        }
        int high = rt;

        return high - low;
    }
}
