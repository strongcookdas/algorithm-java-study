package algorithm.prefix_sum.boj;

/**
 * 누적합 알고리즘 활용
 * 반복문 돌면서 부분합 구하면 시간초과
 * N까지의 누적합을 미리 구한다.
 * 부분합 구할 때마다 누적합을 구한 배열을 활용
 */
import java.util.*;
import java.io.*;

public class 구간합구하기11659 {
    public int solution(int i, int j, int[] arr) {
        return arr[j] - arr[i - 1];
    }

    public static void main(String[] args) throws IOException {
        구간합구하기11659 main = new 구간합구하기11659();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] prefixSum = new int[N + 1];
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int number = Integer.parseInt(st.nextToken());
            prefixSum[i] = prefixSum[i - 1] + number;
        }

        while ((M--) > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            bw.write(main.solution(i, j, prefixSum) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
