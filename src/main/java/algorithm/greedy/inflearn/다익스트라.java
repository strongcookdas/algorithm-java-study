package algorithm.greedy.inflearn;

import java.util.*;

class Node implements Comparable<Edge> {
    public int vex;
    public int cost;

    public Node(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge ob) {
        return this.cost - ob.cost;
    }
}

public class 다익스트라 {
    static int n, m;
    static ArrayList<ArrayList<City>> graph;
    static int[] dis;

    public static void solution(int v) {
        PriorityQueue<City> pQ = new PriorityQueue<>();
        pQ.offer(new City(v, 0));
        dis[v] = 0;
        while (!pQ.isEmpty()) {
            City tmp = pQ.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;
            if (nowCost > dis[now]) continue;
            for (City ob : graph.get(now)) {
                if (dis[ob.vex] > nowCost + ob.cost) {
                    dis[ob.vex] = nowCost + ob.cost;
                    pQ.offer(new City(ob.vex, nowCost + ob.cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        graph = new ArrayList<ArrayList<City>>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<City>());
        }
        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();
            graph.get(a).add(new City(b, c));
        }
        solution(1);
        for (int i = 2; i <= n; i++) {
            if (dis[i] != Integer.MAX_VALUE) System.out.println(i + " : " + dis[i]);
            else System.out.println(i + " : impossible");
        }
    }
}
