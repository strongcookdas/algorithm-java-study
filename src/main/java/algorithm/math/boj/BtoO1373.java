package algorithm.math.boj;

import java.util.*;

public class BtoO1373 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String binary = kb.nextLine();
        StringBuilder sb = new StringBuilder("");
        int temp = 0;
        int count = 0;
        for (int i = binary.length() - 1; i >= 0; i--) {
            if (count == 3) {
                sb.insert(0, temp);
                temp = 0;
                count = 0;
            }
            if (binary.charAt(i) == '1') {
                temp += (int) Math.pow(2, count);
            }
            count++;
        }
        sb.insert(0, temp);

        System.out.println(sb.toString());
    }
}
