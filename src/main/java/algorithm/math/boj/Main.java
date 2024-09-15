package algorithm.math.boj;

// 쉬운 브론즈 문제용 클래스
/**
 * 배수와 약수 5086 B3
 */

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            if (a == 0 && b == 0) {
                break;
            } else {
                if (a < b && a != 0 && b % a == 0) {
                    bw.write("factor\n");
                } else if (b < a && b != 0 && a % b == 0) {
                    bw.write("multiple\n");
                } else {
                    bw.write("neither\n");
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
