package algorithm.brute_force.boj;

import java.util.*;
import java.io.*;

public class 카잉달력6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        카잉달력6064 main = new 카잉달력6064();
        while ((T--) > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            bw.write(main.solution(M, N, x, y) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private int solution(int M, int N, int X, int Y) {
        int lcm = (M * N) / gcd(M, N);
        if (Y == N) {
            Y=0;
        }
        
        for(int year = X; year <= lcm; year+=M){
            if(year % N == Y){
                return year;
            }
        }

        return -1;
    }

    private int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, (a % b));
    }
}