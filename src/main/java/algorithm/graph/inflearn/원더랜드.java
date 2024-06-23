package algorithm.graph.inflearn;

import java.util.*;

public class 원더랜드 {
    static class City implements Comparable<City> {
        int s;
        int d;
        int c;

        public City(int s, int d, int c) {
            this.s = s;
            this.d = d;
            this.c = c;
        }

        @Override
        public int compareTo(City o) {
            return this.c - o.c;
        }
    }

    static int[] unf;
    static City[] arr;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int V = kb.nextInt();
        int E = kb.nextInt();
        unf = new int[V + 1];
        arr = new City[E];
        for (int i = 1; i <= V; i++) {
            unf[i] = i;
        }

        for (int i = 0; i < E; i++) {
            int s = kb.nextInt();
            int d = kb.nextInt();
            int c = kb.nextInt();
            arr[i] = new City(s, d, c);
        }
        Arrays.sort(arr);

        for (City c : arr) {
            union(c);
        }
        System.out.println(answer);
    }

    private static void union(City c) {
        int fa = find(c.s);
        int fb = find(c.d);
        if (fa != fb) {
            unf[fa] = fb;
            answer += c.c;
        }
    }

    private static int find(int v) {
        if (unf[v] == v) {
            return v;
        } else {
            return unf[v] = find(unf[v]);
        }
    }
}
