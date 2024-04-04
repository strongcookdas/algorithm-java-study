package algorithm.hash.inflearn;

import java.util.*;

public class 모든아나그램찾기 { // 다시 풀기
    public static int solution(String s, String t) {
        int answer = 0;
        HashMap<Character, Integer> am = new HashMap<>();
        HashMap<Character, Integer> bm = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            bm.put(t.charAt(i), bm.getOrDefault(t.charAt(i), 0) + 1);
        }
        int lt = 0;
        int rt = 0;
        for (rt = 0; rt < t.length() - 1; rt++) {
            am.put(s.charAt(rt), am.getOrDefault(s.charAt(rt), 0) + 1);
        }

        for (; rt < s.length(); rt++) {
            am.put(s.charAt(rt), am.getOrDefault(s.charAt(rt), 0) + 1);
            if (bm.equals(am)) answer++;
            if (am.get(s.charAt(lt)) == 1) am.remove(s.charAt(lt++));
            else am.put(s.charAt(lt), am.get(s.charAt(lt++)) - 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        System.out.println(solution(s, t));
    }
}
