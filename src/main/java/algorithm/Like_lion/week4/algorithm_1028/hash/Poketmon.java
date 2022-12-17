package algorithm.Like_lion.week4.algorithm_1028.hash;

import java.util.HashSet;
import java.util.Set;

public class Poketmon {
    public int solution(int[] arr){
        Set<Integer> set = new HashSet<>();

        for (int num:
             arr) {
            set.add(num);
        }

        int size = set.size();
        int ans = ((arr.length/2)>size)?size:(arr.length/2);
        return ans;
    }
}
