package algorithm.stack_queue.inflearn;

import java.util.*;

/*
- 큐 사용
- 수업표 반복문 돌면서 필수과목에 포함되어 있는지 확인
    - 있으면 순서 확인
        순서 틀리면 return NO
        맞다면 poll
    - 없으면 poll
 */
public class 교육과정설계 {
    public static String solution(String s, String t) {
        Queue<Character> eSubjects = new LinkedList<>();
        for (char c : s.toCharArray()) {
            eSubjects.offer(c);
        }
        for (int i = 0; i < t.length(); i++) {
            if (eSubjects.contains(t.charAt(i))) {
                if (eSubjects.peek() == t.charAt(i)) eSubjects.poll();
                else return "NO";
            }
        }
        if (!eSubjects.isEmpty()) return "NO";
        return "YES";
    }

    public static String solution2(String s, String t) {//큐 사용 x
        int idx = 0;
        for (int i = 0; i < t.length(); i++) {
            if (s.indexOf(t.charAt(i)) != -1) {
                if (s.charAt(idx) != t.charAt(i)) return "NO";
                else idx++;
            }
        }
        return (idx == s.length()) ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solution2(scanner.nextLine(), scanner.nextLine()));
    }
}
