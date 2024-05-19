package algorithm.math.boj;

import java.util.*;

public class 약수구하기2501 {
    public static int solution(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                list.add(i);
                if (n / i != i) list.add(n / i);
            }
        }
        Collections.sort(list);
        return (list.size() < k) ? 0 : list.get(k - 1);
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        System.out.println(solution(n, k));
    }
}
