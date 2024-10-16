package algorithm.string.bog;

import java.util.*;

public class 소수부분문자열5636 {
    boolean[] isPrime;

    public 소수부분문자열5636() {
        this.isPrime = new boolean[100001];
        Arrays.fill(this.isPrime, true);
        this.isPrime[0] = false;
        this.isPrime[1] = false;
        this.getPrimeNums();
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        소수부분문자열5636 main = new 소수부분문자열5636();

        while (true) {
            String input = kb.nextLine();
            if (input.equals("0")) {
                break;
            }
            String answer = main.solution(input);
            System.out.println(answer);
        }
    }

    private String solution(String input) {
        int maxPrime = -1;
        int length = input.length();

        for (int i = 0; i < length; i++) {
            for (int j = 1; j <= 6 && i + j <= length; j++) {
                String substr = input.substring(i, i + j);
                int num = Integer.parseInt(substr);
                if (num >= 2 && num <= 100000 && this.isPrime[num]) {
                    if (num > maxPrime) {
                        maxPrime = num;
                    }
                }
            }
        }
        return String.valueOf(maxPrime);
    }

    private void getPrimeNums() {
        for (int i = 2; i <= 100000; i++) {
            if (this.isPrime[i]) {
                for (int j = i + i; j <= 100000; j += i) {
                    this.isPrime[j] = false;
                }
            }
        }
    }
}
