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
        Queue<Character> subjects = new LinkedList<>();
        for (char c : s.toCharArray()) {
            eSubjects.offer(c);
        }
        for (char c : t.toCharArray()) {
            subjects.offer(c);
        }
        while (!subjects.isEmpty()) {
            if (eSubjects.contains(subjects.peek())) {
                if (eSubjects.peek() == subjects.peek()) {
                    eSubjects.poll();
                    subjects.poll();
                } else return "NO";
            } else {
                subjects.poll();
            }
        }
        if (!eSubjects.isEmpty()) return "NO";
        return "YES";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solution(scanner.nextLine(), scanner.nextLine()));
    }
}
