package algorithm.math.programmers;

public class 숫자124의나라 {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder("");
        while (n != 0) {
            int mod = n % 3;
            n /= 3;
            if (mod == 0) {
                sb.insert(0, "4");
                n--;
            } else {
                sb.insert(0, mod);
            }
        }
        return sb.toString();
    }
}