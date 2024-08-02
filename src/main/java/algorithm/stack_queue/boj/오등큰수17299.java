package algorithm.stack_queue.boj;

import java.util.*;
import java.io.*;

public class 오등큰수17299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] input = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            map.put(input[i], map.getOrDefault(input[i], 0) + 1);
        }

        오등큰수17299 main = new 오등큰수17299();
        ArrayList<Integer> answer = main.solution(input, map);

        for (int i = answer.size() - 1; i >= 0; i--) {
            bw.write(answer.get(i) + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private ArrayList<Integer> solution(int[] input, HashMap<Integer, Integer> map) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = input.length - 1; i >= 0; i--) {
            int num = input[i];
            int result = -1;
            while (!stack.isEmpty() && (map.get(num) >= map.get(stack.peek()))) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                result = stack.peek();
            }
            stack.push(num);
            answer.add(result);
        }
        return answer;
    }
}
