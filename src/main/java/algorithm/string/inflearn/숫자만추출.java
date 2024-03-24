package algorithm.string.inflearn;

import java.util.Scanner;

public class 숫자만추출 {
    public static int solution(String str) {
        int answer = 0;
//        str = str.replaceAll("[^0-9]","");
//        answer = Integer.parseInt(str);
        for (char x : str.toCharArray()) {
//            if (x >= '0' && x <= '9') answer = answer * 10 + (x - 48);
            if (Character.isDigit(x)) answer = answer * 10 + (x - '0');
        }
        return answer;
    }

    public static void main(String[] argus) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solution(scanner.nextLine()));
    }
}
