package algorithm.greedy.inflearn;

import java.util.*;

/*
오답
0. arr 정렬
1. greedy와 투포인터 사용
2. lt = 다음 타임의 start rt = 현재 타임의 end
    - lt가 rt보다 작으면 answer++ 후 lt는 다음 타임의 start로 대입
    - rt가 lt보다 작으면 answer-- (왜냐 타임라인이 끊겨있다.) 후 rt는 다음 타임의 end로 대입
3. 반복문 실행할때마다 피로연 최대 인원수 비교
 */
class Time implements Comparable<Time> {
    int start, end;

    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Time o) {
        if (this.end == o.end) return this.start - o.start;
        return this.end - o.end;
    }
}

public class 결혼식 {
    static int n, answer = 1;
    static ArrayList<Time> arr = new ArrayList<>();

    public static void solution() {
        if (arr.size() == 1) return;
        Collections.sort(arr);
        for(Time t : arr){
            System.out.println(t.start + " " + t.end);
        }
        System.out.println();
        int lt = 1;
        int rt = 0;
        int c = 1;
        while (rt < lt) {
            System.out.println(arr.get(lt).start + " " + arr.get(rt).end);
            if(lt>=arr.size()||rt>=arr.size())return;
            if (arr.get(lt).start < arr.get(rt).end) {
                c++;
                lt++;
            } else {
                rt++;
                c--;
            }
            answer = Math.max(answer, c);
        }

    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        for (int i = 0; i < n; i++) {
            arr.add(new Time(kb.nextInt(), kb.nextInt()));
        }
        solution();
        System.out.println(answer);
    }
}
