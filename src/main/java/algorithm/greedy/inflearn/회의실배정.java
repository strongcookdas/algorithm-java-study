package algorithm.greedy.inflearn;
/*
1. 끝나는 시간을 기준으로 오름차순으로 정렬 (끝나는 시간이 같으면 시작 시간도 오름차순으로 정렬)
2. tmp 변수에 arr의 첫번째 값 대입
3. 순회하면서 시작시간이 끝나는 시간 이후에 있으면 카운트
4. 카운트함과 동시에 tmp 교체
 */

import java.util.*;

class Meeting implements Comparable<Meeting> {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting o) {
        if (this.end == o.end) return this.start - o.start;
        return this.end - o.end;
    }
}

public class 회의실배정 {
    static int n, answer = 1;
    static ArrayList<Meeting> arr = new ArrayList<>();

    public static void solution() {
        Collections.sort(arr);
//        for (Meeting m : arr) System.out.println(m.start + " " + m.end);
        Meeting tmp = arr.get(0);
        for (int i = 1; i < n; i++) {
            if (tmp.end <= arr.get(i).start){
                tmp = arr.get(i);
                answer++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        for (int i = 0; i < n; i++) {
            arr.add(new Meeting(kb.nextInt(), kb.nextInt()));
        }
        solution();
        System.out.println(answer);
    }
}
