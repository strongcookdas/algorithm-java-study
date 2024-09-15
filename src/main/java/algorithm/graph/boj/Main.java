package algorithm.graph.boj;

// 연습용 클래스
import java.util.*;
import java.io.*;

public class Main {
    static class Node implements Comparable<Node> {
        int v;
        double c;

        public Node(int v, double c) {
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(Node o) {
            return Double.compare(this.c, o.c);
        }
    }

    int[] ch;
    ArrayList<ArrayList<Node>> graph;

    public Main(int n) {
        this.ch = new int[n + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Main main = new Main(N);

        ArrayList<double[]> starList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            starList.add(new double[]{x, y});
        }

        for (int i = 0; i < starList.size(); i++) {
            double x = starList.get(i)[0];
            double y = starList.get(i)[1];
            for (int j = i + 1; j < starList.size(); j++) {
                double nx = starList.get(j)[0];
                double ny = starList.get(j)[1];
                double X = (x - nx) * (x - nx);
                double Y = (y - ny) * (y - ny);
                double dis = Math.sqrt(X + Y);
                main.graph.get(i + 1).add(new Node(j + 1, dis));
                main.graph.get(j + 1).add(new Node(i + 1, dis));
            }
        }

        System.out.printf("%.2f%n", main.solution());
    }

    private double solution() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        double answer = 0;
        pq.offer(new Node(1, 0));
        while (!pq.isEmpty()) {
            Node tmp = pq.poll();
            if (ch[tmp.v] == 0) {
                answer += tmp.c;
                ch[tmp.v] = 1;
                for (Node n : graph.get(tmp.v)) {
                    if (ch[n.v] == 0) {
                        pq.offer(n);
                    }
                }
            }
        }
        return answer;
    }
}
