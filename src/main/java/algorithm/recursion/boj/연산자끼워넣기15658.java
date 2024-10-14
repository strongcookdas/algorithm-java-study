package algorithm.recursion.boj;

import java.util.*;
import java.io.*;

public class 연산자끼워넣기15658 {
    int[] nums;
    int[] operators;
    int[] op;
    int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    public 연산자끼워넣기15658(int N) {
        this.nums = new int[N];
        this.operators = new int[N - 1];
        this.op = new int[4];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        연산자끼워넣기15658 main = new 연산자끼워넣기15658(N);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            main.nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            main.op[i] = Integer.parseInt(st.nextToken());
        }

        main.solution(0);

        System.out.println(main.max);
        System.out.println(main.min);

    }

    private void solution(int L) {
        if (L == this.operators.length) {
            int total = this.nums[0];
            for (int i = 1; i < this.nums.length; i++) {
                switch (this.operators[i - 1]) {
                    case 0:
                        total += this.nums[i];
                        break;
                    case 1:
                        total -= this.nums[i];
                        break;
                    case 2:
                        total *= this.nums[i];
                        break;
                    default:
                        total /= this.nums[i];
                }
            }
            this.max = Math.max(this.max, total);
            this.min = Math.min(this.min, total);
        } else {
            for (int i = 0; i < this.op.length; i++) {
                if (this.op[i] > 0) {
                    this.op[i]--;
                    this.operators[L] = i;
                    solution(L + 1);
                    this.op[i]++;
                }
            }
        }
    }
}
