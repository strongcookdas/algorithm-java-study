package algorithm.stack_queue.boj;

import java.util.*;
import java.io.*;

public class 덱10866 {
    LinkedList<Integer> deq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        덱10866 main = new 덱10866();
        main.deq = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String menu = st.nextToken();
            switch (menu) {
                case "push_front":
                    main.push_front(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    main.push_back(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    bw.write(main.pop_front() + "\n");
                    break;
                case "pop_back":
                    bw.write(main.pop_back() + "\n");
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
        if(deq.size()==0) return -1;
        return deq.getLast();
    }

    private int front() {
        if(deq.size()==0) return -1;
        return deq.getFirst();
    }

    private int empty() {
        if(deq.size()==0) return 1;
        return 0;
    }

    private int size() {
        return deq.size();
    }

    private int pop_back() {
        if(deq.size()==0) return -1;
        int num = deq.getLast();
        deq.removeLast();
        return num;
    }

    private int pop_front() {
        if(deq.size()==0) return -1;
        int num = deq.getFirst();
        deq.removeFirst();
        return num;
    }

    private void push_back(int i) {
        deq.addLast(i);
    }

    private void push_front(int i) {
        deq.addFirst(i);
    }
}
