package algorithm.greedy.inflearn;

// 입력을 받는 형식이 중요
// 나가는 시간과 들어오는 시간을 구분하여 입력을 받아야 한다.
// Time 이라는 객체 생성 (시간과 나가는 시간인지 들어오는 시간이지 구분하는 필드)

import java.util.*;

public class 결혼식 {
    static class Time {
        int time;
        int tmp; // 0이면 입장 , 1이면 퇴장

        public Time(int time, int tmp) {
            this.time = time;
            this.tmp = tmp;
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        ArrayList<Time> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(new Time(kb.nextInt(), 0));
            list.add(new Time(kb.nextInt(), 1));
        }

        결혼식 main = new 결혼식();
        System.out.println(main.solution(list));
    }

    private int solution(ArrayList<Time> list) {
        list.sort((a, b) -> {
            if (a.time == b.time) {
                return b.tmp - a.tmp;
            }
            return a.time - b.time;
        });

        int count = 0;
        int answer = 0;
        for (Time t : list) {
            if (t.tmp == 1) {
                count--;
            } else {
                count++;
                answer = Math.max(count, answer);
            }
        }
        return answer;
    }
}
