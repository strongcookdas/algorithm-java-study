package algorithm.hash.inflearn;

import java.util.*;

public class 아나그램 {
    public String solution(String str1, String str2) {
        String answer = "YES";
        if (str1.length() != str2.length()) return "NO";
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            map.put(str1.charAt(i), map.getOrDefault(str1.charAt(i), 0) + 1);
            map.put(str2.charAt(i), map.getOrDefault(str2.charAt(i), 0) - 1);
        }
        for (Character key : map.keySet()) {
            if (map.get(key) != 0) return "NO";
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        아나그램 main = new 아나그램();
        System.out.println(main.solution(kb.nextLine(), kb.nextLine()));
    }
}
