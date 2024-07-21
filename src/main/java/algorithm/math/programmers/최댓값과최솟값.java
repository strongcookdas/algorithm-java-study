package algorithm.math.programmers;

import java.math.*;

public class 최댓값과최솟값 {
    public String solution(String s) {
        String[] inputs = s.split(" ");

        BigInteger min = new BigInteger(inputs[0]);
        BigInteger max = new BigInteger(inputs[0]);

        for (int i = 1; i < inputs.length; i++) {
            BigInteger c = new BigInteger(inputs[i]);

            if (min.compareTo(c) > 0) {
                min = c;
            }
            if (max.compareTo(c) < 0) {
                max = c;
            }
        }
        return min.toString() + " " + max.toString();
    }
}
