package algorithm.hash.boj;

import java.util.*;
import java.io.*;

public class 추월2002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        추월2002 main = new 추월2002();
        ArrayList<String> inputs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            inputs.add(br.readLine());
        }

        ArrayList<String> inputs2 = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            inputs2.add(br.readLine());
        }

        bw.write(main.solution(inputs, inputs2));
        bw.flush();
        bw.close();
        br.close();
    }

    private String solution(ArrayList<String> inputs, ArrayList<String> inputs2) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        int[] count = new int[inputs.size()];
        for (int i = 0; i < inputs.size(); i++) {
            map.put(inputs.get(i), i);
        }

        for (int i = 0; i < inputs2.size(); i++) {
            int carIdx = map.get(inputs2.get(i));
            if (i - count[carIdx] != carIdx) {
                answer++;
                for (int j = 0; j < carIdx; j++) {
                    count[j]++;
                }
            }
        }
        return String.valueOf(answer);
    }
}
