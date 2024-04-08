package algorithm.stack_queue;

import java.io.*;

public class Boj10828 {
    // 백준 10828 스택

    int[] stack = new int[10001];
    int top = -1;

    public void push(int num) {
        this.stack[++this.top] = num;
    }

    public int pop() {
        return (this.top == -1) ? this.top : this.stack[this.top--];
    }

    public int size() {
        return top + 1;
    }

    public int empty() {
        return (this.top == -1) ? 1 : 0;
    }

    public int top() {
        return (this.top == -1) ? this.top : this.stack[top];
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());
        while ((cnt--) > 0) {
            String[] code = br.readLine().split(" ");
            switch (code[0]) {
                case "push":
                    int num = Integer.parseInt(code[1]);
                    this.push(num);
                    break;
                case "pop":
                    bw.write(this.pop()+"\n");
                    break;
                case "size":
                    bw.write(this.size()+"\n");
                    break;
                case "empty":
                    bw.write(this.empty()+"\n");
                    break;
                case "top":
                    bw.write(this.top()+"\n");
                    break;
            }
        }
        bw.flush();
    }

    public static void main(String[] args)throws IOException {
        Boj10828 problem = new Boj10828();
        problem.solution();
    }
}
