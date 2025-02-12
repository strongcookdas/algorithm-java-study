package algorithm.brute_force.boj;

import java.util.*;
import java.io.*;

public class 카잉달력6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            bw.write(calculate(M,N,x,y)+"\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static int calculate(int M, int N, int x, int y){
        int lcm = M*N/gcd(M,N);
        if(N==y){
            y = 0;
        }

        for(int i = x; i<=lcm; i+=M){
            if(i%N==y){
                return i;
            }
        }

        return -1;
    }

    public static int gcd(int a, int b){
        if(a%b == 0){
            return b;
        }
        return gcd(b,a%b);
    }
}