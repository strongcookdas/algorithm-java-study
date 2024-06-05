package algorithm.hash.programmers;

import java.util.HashMap;

public class 완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        String answer = "";
        for (String name : participant) map.put(name, map.getOrDefault(name, 0) + 1);
        for (String name : completion) map.put(name, map.get(name) - 1);
        for (String name : map.keySet()) {
            if (map.get(name) != 0) answer = name;
        }
        return answer;
    }
}
