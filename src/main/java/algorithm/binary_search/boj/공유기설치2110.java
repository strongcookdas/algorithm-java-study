package algorithm.binary_search.boj;

import java.util.*;
import java.io.*;

public class 공유기설치2110 {
    int N, C;
    int[] map;

    public 공유기설치2110(int n, int c) {
        this.N = n;
        this.C = c;
        this.map = new int[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        공유기설치2110 main = new 공유기설치2110(N, C);
        for (int i = 0; i < N; i++) {
            main.map[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(main.solution());
    }

    private int solution() {
        int lt = 1, rt = this.map[this.map.length - 1];
        int answer = 1;
        Arrays.sort(this.map);

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (getCount(mid) >= this.C) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        return answer;
    }

    private int getCount(int dis) {
        int count = 1;
        int prev = this.map[0];
        for (int i = 1; i < this.map.length; i++) {
            if (Math.abs(prev - this.map[i]) >= dis) {
                count++;
                prev = this.map[i];
            }
        }
        return count;
    }
}
