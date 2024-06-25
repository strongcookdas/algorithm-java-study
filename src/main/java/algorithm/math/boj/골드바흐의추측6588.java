package algorithm.math.boj;

import java.util.*;
import java.io.*;

public class 골드바흐의추측6588 {
    boolean[] primeArr;

    public 골드바흐의추측6588(int max) {
        primeArr = getPrimeList(max);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> inputs = new ArrayList<>();
        int input, max = Integer.MIN_VALUE;
        String line;
        while ((line = br.readLine()) != null) {
            input = Integer.parseInt(line);
            if (input == 0) {
                break;
            }
            inputs.add(input);
            max = Math.max(input, max);
        }

        골드바흐의추측6588 main = new 골드바흐의추측6588(max);
        for (int i : inputs) {
            int[] answer = main.solution(i);
            int a = answer[0];
            int b = answer[1];
            if (a + b == i) {
                bw.write(i + " = " + a + " + " + b + "\n");
            } else {
                bw.write("Goldbach's conjecture is wrong.\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private int[] solution(int input) {
        int[] answer = new int[2];
        for (int i = 3; i <= input / 2; i += 2) {
            if (primeArr[i] && primeArr[input - i]) {
                answer[0] = i;
                answer[1] = input - i;
                return answer;
            }
        }
        return answer;
    }

    private boolean[] getPrimeList(int input) {
        boolean[] arr = new boolean[input + 1];
        Arrays.fill(arr, true);
        arr[0] = arr[1] = false;
        for (int i = 2; i * i <= input; i++) {
            if (arr[i]) {
                for (int j = i * i; j <= input; j += i) {
                    arr[j] = false;
                }
            }
        }
        return arr;
    }
}
