package algorithm.stack_queue.boj;

import java.util.*;
import java.io.*;

public class 요세푸스문제1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        요세푸스문제1158 main = new 요세푸스문제1158();

        ArrayList<Integer> answer = main.solution(queue, K);
        bw.write("<");
        for (int i = 0; i < answer.size(); i++) {
            if (i == answer.size() - 1) {
                bw.write(answer.get(i).toString());
            } else {
                bw.write(answer.get(i) + ", ");
            }
        }
        bw.write(">");
        bw.flush();
    }

    private ArrayList<Integer> solution(Queue<Integer> queue, int k) {
        ArrayList<Integer> answer = new ArrayList<>();
        while (!queue.isEmpty()) {
            int count = 1;
            while ((count++) < k) {
                queue.offer(queue.poll());
            }
            answer.add(queue.poll());
        }
        return answer;
    }
}
