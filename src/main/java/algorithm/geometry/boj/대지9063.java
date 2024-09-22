package algorithm.geometry.boj;

import java.io.*;
import java.util.*;

public class 대지9063 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int xMax = Integer.MIN_VALUE;
        int xMin = Integer.MAX_VALUE;
        int yMax = Integer.MIN_VALUE;
        int yMin = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            xMax = Math.max(x, xMax);
            xMin = Math.min(x, xMin);
            yMax = Math.max(y, yMax);
            yMin = Math.min(y, yMin);
        }
        if (N == 1) {
            System.out.println(0);
        } else {
            System.out.println(Math.abs(xMax - xMin) * Math.abs(yMax - yMin));
        }
        br.close();
    }
}
