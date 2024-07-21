package algorithm.stack_queue.boj;

// 스택 한개 사용
// 스택 top에 자신보다 큰 숫자가 있으면 기록 작으면 pop() (거꾸로 순회하기때문에 작은 수는 필요 없음) 없으면 -1
// 기록 후 해당 수 스택에 push 후 반복
// 입력 순 거꾸로 순회

import java.io.*;
import java.util.*;

public class 오큰수17298 {
    int[] inputs;
    Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        오큰수17298 main = new 오큰수17298();
        main.inputs = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            main.inputs[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = main.solution();

        for (int n : answer) {
            bw.write(String.valueOf(n));
            bw.write(" ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private int[] solution() {
        int[] answer = new int[inputs.length];
        Arrays.fill(answer, -1);
        stack = new Stack<>();
        for (int i = inputs.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && inputs[i] >= stack.peek()) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                answer[i] = stack.peek();
            }
            stack.push(inputs[i]);
        }
        return answer;
    }
}
