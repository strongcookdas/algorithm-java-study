package algorithm.binary_search.boj;

import java.io.*;
import java.util.*;

public class 공유기설치2110 {
    int[] position;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        공유기설치2110 main = new 공유기설치2110();
        main.position = new int[N];
        for (int i = 0; i < N; i++) {
            main.position[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(main.solution(C));
    }

    private int solution(int c) {
        Arrays.sort(position);
        int lt = 0, rt = position[position.length - 1];
        int answer = 0;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(mid) >= c) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        return answer;
    }

    private int count(int mid) {
        int count = 1;
        int before = 0;
        for (int i = 1; i < position.length; i++) {
            if (position[i] - position[before] >= mid) {
                before = i;
                count++;
            }
        }
        return count;
    }
}
