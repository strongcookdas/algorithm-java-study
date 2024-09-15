package algorithm.geometry.boj;

import java.util.*;

public class 직사각형에서탈출1085 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int x = kb.nextInt();
        int y = kb.nextInt();
        int w = kb.nextInt();
        int h = kb.nextInt();

        int width = Math.min(x, Math.abs(x - w));
        int height = Math.min(y, Math.abs(y - h));

        System.out.println(Math.min(width, height));
    }
}
