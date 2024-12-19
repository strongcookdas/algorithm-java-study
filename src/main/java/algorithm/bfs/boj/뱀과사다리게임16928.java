package algorithm.bfs.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class 뱀과사다리게임16928 {

    Map<Integer, Integer> ladder;
    Map<Integer, Integer> snake;
    int[] map;

    public 뱀과사다리게임16928() {
        ladder = new HashMap<>();
        snake = new HashMap<>();
        map = new int[101];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            main.snake.put(x, y);
        }

        System.out.println(main.bfs());

    }

    public int bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        map[1] = 1;
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int n = q.poll();
                if (n == 100) {
                    return count;
                }
                for (int j = 1; j <= 6; j++) {
                    int nextN = n + j;
                    if (nextN > 100 || map[nextN] != 0) {
                        continue;
                    }
                    if (ladder.containsKey(nextN)) {
                        nextN = ladder.get(nextN);
                    } else if (snake.containsKey(nextN)) {
                        nextN = snake.get(nextN);
                    }
                    map[nextN] = 1;
                    q.add(nextN);
                }
            }
            count++;
        }
        return -1;
    }
}

/*
시간 복잡도 : O(600) 100*6
시간 : 120ms
메모리 : 14680kb
 */
