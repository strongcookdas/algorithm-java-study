package algorithm.string.inflearn;

import java.util.*;

public class 단어뒤집기 {
    public static ArrayList<String> solution(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>();
//        for (String s : str) {
//            StringBuilder tmp = new StringBuilder(s);
//            answer.add(tmp.reverse().toString());
//        }
        for (String x : str) {
            char[] s = x.toCharArray();
            int lt = 0;
            int rt = x.length()-1;
            while (lt < rt) {
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
            String tmp = String.valueOf(s);
            answer.add(tmp);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = scanner.next();
        }
        for (String s : solution(n, str)) {
            System.out.println(s);
        }
    }
}
