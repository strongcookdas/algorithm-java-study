package week6.algorithm_1107;

public class Hashad {
    public boolean solution(int num) {
        int sum = 0;
        int tmp = num;
        while (tmp > 0) {
            sum += (tmp % 10);
            tmp /= 10;
        }
        if (num % sum == 0)
            return true;
        return false;
    }

    public static void main(String[] args) {
        Hashad h = new Hashad();
        System.out.println(h.solution(11));
    }
}
