package algorithm.sort.inflearn;

import java.util.*;

public class 좌표정렬 {
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] argus) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Point> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) arr.add(new Point(scanner.nextInt(), scanner.nextInt()));
        Collections.sort(arr, (a, b) -> {
            if(a.x==b.x) return a.y-b.y;
            return a.x-b.x;
        });
        for (Point c : arr) System.out.println(c.x + " " + c.y);
    }
}
