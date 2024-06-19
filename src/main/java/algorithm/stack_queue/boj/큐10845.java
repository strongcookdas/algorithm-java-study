package algorithm.stack_queue.boj;

import java.io.*;
import java.util.*;

public class 큐10845 {
    LinkedList<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        큐10845 main = new 큐10845();
        main.queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String menu = st.nextToken();
            switch (menu) {
                case "push":
                    main.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    bw.write(main.pop() + "\n");
                    break;
                case "size":
                    bw.write(main.size() + "\n");
                    break;
                case "empty":
                    bw.write(main.empty() + "\n");
                    break;
                case "front":
                    bw.write(main.front() + "\n");
                    break;
                default:
                    bw.write(main.back() + "\n");
                    break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private int back() {
        if (queue.size() == 0) {
            return -1;
        }
        return queue.get(queue.size() - 1);
    }

    private int front() {
        if (queue.size() == 0) {
            return -1;
        }
        return queue.get(0);
    }

    private int empty() {
        if (queue.size() == 0) {
            return 1;
        }
        return 0;
    }

    private int size() {
        return queue.size();
    }

    private int pop() {
        if (queue.size() == 0) {
            return -1;
        }
        int num = queue.get(0);
        queue.remove(0);
        return num;
    }

    private void push(int i) {
        queue.add(i);
    }
}
