package algorithm.math.boj;

import java.util.*;
import java.io.*;

public class 골드바흐의추측6588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = "";
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> list = new ArrayList<>();

        while ((input = br.readLine()) != null) {
            if (input.equals("0")) break;
            int n = Integer.parseInt(input);
            if (n > max) max = n;
            list.add(n);
        }

        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i + i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int num : list) {
            boolean flag = true;
            for (int i = 3; i <= num / 2; i += 2) {
                int a = i;
                int b = num - a;
                if (isPrime[a] & isPrime[b]) {
                    bw.write(num + " = " + a + " + " + b + "\n");
                    flag = false;
                    break;
                }
            }
            if (flag) {
                bw.write("Goldbach's conjecture is wrong.\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
