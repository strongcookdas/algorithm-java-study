package algorithm.prefix_sum.boj;

import java.util.*;
import java.io.*;

public class 인간컴퓨터상호작용16139 {
    int[][] prefixSum;

    public 인간컴퓨터상호작용16139(String str) {
        prefixSum = new int[26][str.length()];
        for (char i = 'a'; i <= 'z'; i++) {
            int count = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == i) {
                    count++;
                }
                this.prefixSum[i - 'a'][j] = count;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int N = Integer.parseInt(br.readLine());
        인간컴퓨터상호작용16139 main = new 인간컴퓨터상호작용16139(str);
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char word = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            bw.write(String.valueOf(main.solution(word, start, end)) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private int solution(char word, int start, int end) {
        int idx = word - 'a';
        int answer = 0;
        if (start > 0) {
            answer = this.prefixSum[idx][end] - this.prefixSum[idx][start - 1];
        } else {
            answer = this.prefixSum[idx][end];
        }
        return answer;
    }
}
