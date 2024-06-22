package algorithm.math.boj;

import java.io.*;
import java.util.*;

public class 소수구하기1929 {
    int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        소수구하기1929 main = new 소수구하기1929();
        ArrayList<Integer> answer = main.solution(M, N);
        for (int n : answer) {
            bw.write(n + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private ArrayList<Integer> solution(int m, int n) {
        arr = new int[n + 1];
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) {
                for (int j = i * 2; j <= n; j += i) {
                    arr[j] = 1;
                }
            }
        }
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = m; i <= n; i++) {
            if (arr[i] == 0) {
                answer.add(i);
            }
        }
        return answer;
    }
}
