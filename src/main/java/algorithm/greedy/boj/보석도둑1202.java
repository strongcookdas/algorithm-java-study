package algorithm.greedy.boj;

import java.util.*;

public class 보석도둑1202 {

    static class Jewel {
        int weight;
        int price;

        public Jewel(int w, int p) {
            this.weight = w;
            this.price = p;
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int N = kb.nextInt();
        int K = kb.nextInt();

        ArrayList<Jewel> jList = new ArrayList<>();
        ArrayList<Integer> bList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            jList.add(new Jewel(kb.nextInt(), kb.nextInt()));
        }

        for (int i = 0; i < K; i++) {
            bList.add(kb.nextInt());
        }

        보석도둑1202 main = new 보석도둑1202();
        System.out.println(main.solution(jList, bList, N, K));

    }

    private long solution(ArrayList<Jewel> jList, ArrayList<Integer> bList, int n, int k) {
        jList.sort(Comparator.comparingInt(a -> a.weight));
        bList.sort(Comparator.comparingInt(a -> a));

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int idx = 0;
        long answer = 0L;
        for (int i = 0; i < k; i++) {
            int weight = bList.get(i);
            while (idx < jList.size() && jList.get(idx).weight <= weight) {
                pq.add(jList.get(idx).price);
                idx++;
            }
            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }
        return answer;
    }
}
