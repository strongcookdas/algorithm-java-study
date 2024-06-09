package algorithm.bfs.boj;
/**
 * BFS, 해시셋 활용
 */

import java.util.*;

public class 스타트링크5014 {
    public String solution(int F, int S, int G, int U, int D) {
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(S);
        int count = 0;
        int[] arr = {U, D};
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                int f = q.poll();
                if (f == G) return String.valueOf(count);
                for (int j = 0; j < arr.length; j++) {
                    int nextF = f + arr[j];
                    if (nextF > 0 && nextF <= F && !visited.contains(nextF)) {
                        q.offer(nextF);
                        visited.add(nextF);
                    }
                }
            }
            ++count;
        }
        return "use the stairs";
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String[] inputs = kb.nextLine().split(" ");
        스타트링크5014 main = new 스타트링크5014();

        int F = Integer.parseInt(inputs[0]);
        int S = Integer.parseInt(inputs[1]);
        int G = Integer.parseInt(inputs[2]);
        int U = Integer.parseInt(inputs[3]);
        int D = -Integer.parseInt(inputs[4]);
        System.out.println(main.solution(F, S, G, U, D));
    }
}
