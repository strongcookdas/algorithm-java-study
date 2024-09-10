package algorithm.string.bog;

import java.util.*;

public class 사다리타기2469 {
    char[] input;
    char[] output;
    ArrayList<String> ladder1;
    ArrayList<String> ladder2;

    public 사다리타기2469(int K) {
        this.input = new char[K];
        this.output = new char[K];
        this.ladder1 = new ArrayList<>();
        this.ladder2 = new ArrayList<>();
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int K = kb.nextInt();
        int N = kb.nextInt();
        kb.nextLine();

        사다리타기2469 main = new 사다리타기2469(K);
        String result = kb.nextLine();
        for (int i = 0; i < K; i++) {
            char word = result.charAt(i);
            main.output[i] = word;
            main.input[i] = (char) ('A' + i);
        }

        boolean flag = false;
        for (int i = 0; i < N; i++) {
            String input = kb.nextLine();
            if (input.contains("?")) {
                flag = true;
            }
            if (flag) {
                main.ladder2.add(input);
            } else {
                main.ladder1.add(input);
            }
        }

        System.out.println(main.solution(K));
    }

    private String solution(int K) {
        char[] inputResult = input.clone();
        char[] outputResult = output.clone();

        char[] tmp = new char[K];

        for (int i = 0; i < ladder1.size(); i++) {
            String ladderRow = ladder1.get(i);
            for (int j = 0; j < K - 1; j++) {
                if (ladderRow.charAt(j) == '-') {
                    char swap = inputResult[j];
                    inputResult[j] = inputResult[j + 1];
                    inputResult[j + 1] = swap;
                }
            }
        }

        for (int i = ladder2.size() - 1; i >= 0; i--) {
            String ladderRow = ladder2.get(i);
            for (int j = 0; j < K - 1; j++) {
                if (ladderRow.charAt(j) == '-') {
                    char swap = outputResult[j];
                    outputResult[j] = outputResult[j + 1];
                    outputResult[j + 1] = swap;
                }
            }
        }

        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < K - 1; i++) {
            if (inputResult[i] == outputResult[i]) {
                sb.append("*");
            } else if (inputResult[i] == outputResult[i + 1] && inputResult[i + 1] == outputResult[i]) {
                sb.append("-");
                char swap = inputResult[i];
                inputResult[i] = inputResult[i + 1];
                inputResult[i + 1] = swap;
            } else {
                StringBuilder answer = new StringBuilder("");
                for (int j = 0; j < K - 1; j++) {
                    answer.append("x");
                }
                return answer.toString();
            }

        }
        return sb.toString();
    }
}
