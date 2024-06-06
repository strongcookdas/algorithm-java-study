package algorithm.hash.programmers;
/**
 * 해시
 * 종류 개수와 안입을 경우 +1 생각해서 조합을 구한다.
 */

import java.util.*;

public class 의상 {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1);
        }
        for (String key : map.keySet()) {
            answer *= (map.get(key)+1);
        }
        return answer-1;
    }
}
