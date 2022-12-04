package algorithm.stack;

import java.io.*;
import java.util.Stack;

public class Boj1874 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());
        int num;
        int count = 1;
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        while (cnt-- > 0) {
            num = Integer.parseInt(br.readLine());
            while (true) {
                if (stack.isEmpty() || stack.peek() < num) {
                    sb.append("+\n");
                    stack.push(count++);
                } else if (stack.peek() == num) {
                    sb.append("-\n");
                    stack.pop();
                    break;
                } else if (stack.peek() > num) {
                    System.out.println("NO");
                    return;
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        Boj1874 problem = new Boj1874();
        problem.solution();
    }
}
