package algorithm.sort.inflearn;

import java.util.*;

class Point implements Comparable<Point> {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if (this.x == o.x) return this.y - o.y;
        else return this.x - o.x;
    }
}

public class 좌표정렬 {
    public static void main(String[] argus) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Point> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) arr.add(new Point(scanner.nextInt(), scanner.nextInt()));
        Collections.sort(arr);
        for (Point c : arr) System.out.println(c.x + " " + c.y);
    }
}
