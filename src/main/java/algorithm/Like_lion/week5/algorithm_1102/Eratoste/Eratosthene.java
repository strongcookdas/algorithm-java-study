package algorithm.Like_lion.week5.algorithm_1102.Eratoste;

import java.util.ArrayList;
import java.util.List;

public class Eratosthene {

    public int solution(int N){
        List<Integer> nums = new ArrayList<>();

        for (int i = 2; i < N+1; i++) {
            nums.add(i);
        }

        for(int j = 2; j*j <=N;j++) {
            for (int i = 0; i < nums.size(); i++) {
                if (nums.get(i) % j == 0 && nums.get(i) > j)
                    nums.remove(i);
            }
        }
        return nums.size();
    }
    public static void main(String[] args) {
        Eratosthene e = new Eratosthene();
        System.out.println(e.solution(5));
    }
}
