package algorithm.string.inflearn;

import java.util.Scanner;

public class 중복문자제거 {
    public static String solution(String str) {
        String answer = "";
        for (int i = 0; i < str.length(); i++) {
            if(str.indexOf(str.charAt(i)) == i) answer+=str.charAt(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solution(scanner.nextLine()));
    }
}
