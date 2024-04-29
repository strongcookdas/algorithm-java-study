package algorithm.greedy.inflearn;

import java.util.*;

class Lecture implements Comparable<Lecture> {
    int pay;
    int limit;

    public Lecture(int pay, int limit) {
        this.pay = pay;
        this.limit = limit;
    }

    @Override
    public int compareTo(Lecture o) {
        return o.limit - this.limit; // 내림차순
    }
}

public class 최대수입스케줄 {
    static ArrayList<Lecture> arr = new ArrayList<>();
    static PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
    static int answer = 0, limitMax = Integer.MIN_VALUE;

    public static void solution() {
        Collections.sort(arr);
        int idx = 0;
        for (int i = limitMax; i > 0; i--) {
            while (idx < arr.size() && arr.get(idx).limit == i) pQ.offer(arr.get(idx++).pay);
            if (!pQ.isEmpty()) answer += pQ.poll();
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        for (int i = 0; i < n; i++) {
            int pay = kb.nextInt();
            int limit = kb.nextInt();
            arr.add(new Lecture(pay, limit));
            limitMax = Math.max(limitMax, limit);
        }
        solution();
        System.out.println(answer);
    }
}
