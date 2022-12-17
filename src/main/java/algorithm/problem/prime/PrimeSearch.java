package algorithm.problem.prime;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PrimeSearch {
 /*
    1. DFS로 숫자 조합을 한다.
    2. 해당 수가 소수인지 판별한다.
  */

    String numbers;
    Set<Integer> set = new HashSet<>();
    boolean[] check;
    StringBuilder result = new StringBuilder("");

    public void dfs(int depth) {
        if (depth > numbers.length()) {
            return;
        } else {
            for (int i = 0; i < numbers.length(); i++) {
                if (check[i] == true) {
                    result.append(numbers.charAt(i));
                    check[i] = false;
                    this.set.add(Integer.parseInt(result.toString()));
                    dfs(depth + 1);
                    result.deleteCharAt(result.length() - 1);
                    check[i] = true;
                }
            }
        }
    }

    public boolean isPrime(int n) {
        if (n == 0 || n == 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public int solution(String numbers) {
        int cnt = 0;
        this.numbers = numbers;
        this.check = new boolean[numbers.length()];
        Arrays.fill(this.check, true);
        this.dfs(0);
        Iterator<Integer> iter = set.iterator();
        while (iter.hasNext()) {
            int num = iter.next();
            if (this.isPrime(num) == true) cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        PrimeSearch primeSearch = new PrimeSearch();
        System.out.println(primeSearch.solution("17"));
    }
}
