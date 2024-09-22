package algorithm.math.boj;

import java.util.*;

public class 숨바꼭질17087 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int S = kb.nextInt();
        kb.nextLine();

        StringTokenizer st = new StringTokenizer(kb.nextLine());
        int answer = Math.abs(S - Integer.parseInt(st.nextToken()));

        숨바꼭질17087 main = new 숨바꼭질17087();
        for (int i = 1; i < N; i++) {
            int tmp = Math.abs(S - Integer.parseInt(st.nextToken()));
            answer = main.getGCD(Math.max(answer, tmp), Math.min(answer, tmp));
        }

        System.out.println(answer);
    }

    private int getGCD(int a, int b) {
        while (true) {
            if (b == 0) {
                return a;
            }
            int tmp = b;
            b = a % b;
            a = tmp;
        }
    }
}
