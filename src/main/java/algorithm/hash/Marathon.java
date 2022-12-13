package algorithm.hash;

import java.util.HashMap;
import java.util.Map;

/*
프로그래머스: 완주하지 못한 선수
1. 참가자 배열을 순회하면서 Map으로 참가자를 추가 및 값을 1을 더한다.
2. 완주자 배열을 순회하면서 Map의 값에 1을 뺀다.
3. 값이 0이 아닌 선수를 반환한다.
 */
public class Marathon {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        String ans = "";
        for (String key : participant) {
//            if (map.containsKey(key)) map.put(key, map.get(key) + 1);
//            else map.put(key, 1);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (String key : completion) {
            map.put(key, map.get(key) - 1);
        }

        for (String key : participant) {
            if (map.get(key) != 0)
                ans = key;
        }

        return ans;
    }

    public static void main(String[] args) {
        Marathon marathon = new Marathon();
        System.out.println(marathon.solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
    }
}
