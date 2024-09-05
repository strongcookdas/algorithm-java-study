package algorithm.bfs.boj;

import java.util.*;
import java.io.*;

public class 뱀과사다리게임16928 {
    HashMap<Integer, Integer> ladder;
    HashMap<Integer, Integer> snake;

    public 뱀과사다리게임16928() {
        ladder = new HashMap<>();
        snake = new HashMap<>();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        뱀과사다리게임16928 main = new 뱀과사다리게임16928();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            main.ladder.put(x, y);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            main.snake.put(u, v);
        }

        bw.write(main.solution());
        bw.flush();
        bw.close();
        br.close();
    }

    private String solution() {
        int[] ch = new int[101];
        Queue<Integer> q = new LinkedList<>();
        int start = 1;
        ch[1] = 1;

        q.offer(start);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int idx = q.poll();
                if (idx == 100) {
                    return String.valueOf(ch[idx] - 1);
                }
                for (int j = 1; j <= 6; j++) {
                    int nextIdx = idx + j;
                    if (nextIdx <= 100 && ch[nextIdx] == 0) {
                        if (ladder.containsKey(nextIdx)) {
                            nextIdx = ladder.get(nextIdx);
                        } else if (snake.containsKey(nextIdx)) {
                            nextIdx = snake.get(nextIdx);
                        }

                        if (ch[nextIdx] == 0) {
                            ch[nextIdx] = ch[idx] + 1;
                            q.offer(nextIdx);
                        }
                    }
                }
            }
        }
        return String.valueOf(0);
    }
}
