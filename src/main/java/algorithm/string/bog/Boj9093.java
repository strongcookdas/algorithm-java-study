package algorithm.string.bog;

import java.util.*;

public class Boj9093 { //단어뒤집기
    public static ArrayList<String> solution(String str) {
        ArrayList<String> answer = new ArrayList<>();
        String[] s = str.split(" ");
        for (String string : s) {
            answer.add(new StringBuilder(string).reverse().toString());
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        while ((n--) > 0) {
            String str = scanner.nextLine();
            for (String s : solution(str)) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
