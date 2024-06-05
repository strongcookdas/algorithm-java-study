package algorithm.set.programmers;

import java.util.HashSet;
import java.util.Set;

public class 폰켓몬 {
    public int solution(int[] arr){
        Set<Integer> set = new HashSet<>();
        for(int type : arr) set.add(type);
        if(set.size()>=(arr.length/2)) return arr.length/2;
        else return set.size();
    }
}
