package algorithm.hash.inflearn;

import java.util.*;

public class 아나그램 {
    public static String solution(String str1, String str2) {
        String answer = "YES";
//        HashMap<Character, Integer> map1 = new HashMap<>();
//        HashMap<Character, Integer> map2 = new HashMap<>();
//        for (int i = 0; i < str1.length(); i++) {
//            map1.put(str1.charAt(i), map1.getOrDefault(str1.charAt(i), 0) + 1);
//            map2.put(str2.charAt(i), map2.getOrDefault(str2.charAt(i), 0) + 1);
//        }
//        for (char key : map1.keySet()) {
//            if (!map2.containsKey(key) || !map2.get(key).equals(map1.get(key))) answer = "NO";
//        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(char x : str1.toCharArray()){
            map.put(x, map.getOrDefault(x,0)+1);
        }
        for(char key : str2.toCharArray()){
            if(!map.containsKey(key) || map.get(key) == 0) return "NO";
            map.put(key,map.get(key)-1);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();
        System.out.println(solution(str1, str2));
    }
}
