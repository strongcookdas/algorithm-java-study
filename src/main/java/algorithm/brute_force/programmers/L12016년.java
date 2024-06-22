package algorithm.brute_force.programmers;

/**
 * 나의 풀이 월의 1일이 무슨 요일인지 파악해야 함 좋은 방법 x
 */
public class L12016년 {
    /* 나의 풀이
    String[] week = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
    int[] year = {4,0,1,4,6,2,4,0,3,5,1,3};
    public String solution(int a, int b) {
        String answer = "";
        answer = week[(b+year[a-1])%7];
        return answer;
    }
    */
    String[] week = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
    int[] year = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public String solution(int a, int b) {
        int days = b;
        for (int i = 0; i < a - 1; i++) {
            days += year[i];
        }
        return week[days % 7];
    }

}
