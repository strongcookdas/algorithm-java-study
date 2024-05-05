package algorithm.greedy.inflearn;

import java.util.*;

class City implements Comparable<City> {
    public int vex;
    public int cost;

    City(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(City o) {
        return this.cost - o.cost;
    }
}

public class 원더랜드PQ {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        ArrayList<ArrayList<City>> graph = new ArrayList<ArrayList<City>>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<City>());
        }
        int[] ch = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();
            graph.get(a).add(new City(b, c));
            graph.get(b).add(new City(a, c));
        }
        int answer = 0;
        PriorityQueue<City> pQ = new PriorityQueue<>();
        pQ.offer(new City(1, 0));
        while (!pQ.isEmpty()) {
            City tmp = pQ.poll();
            int ev = tmp.vex;
            if (ch[ev] == 0) {
                ch[ev] = 1;
                answer += tmp.cost;
                for (City c : graph.get(ev)) {
                    if (ch[c.vex] == 0) pQ.offer(new City(c.vex, c.cost));
                }
            }
        }
        System.out.println(answer);
    }
}
