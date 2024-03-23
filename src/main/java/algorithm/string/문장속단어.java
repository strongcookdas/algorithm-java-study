package algorithm.string;

import java.util.*;

public class 문장속단어 {
    public static String solution(String str) {
        String answer = "";
        int m = Integer.MIN_VALUE, pos;
//        String[] s = str.split(" ");
//        for (String string : s) {
//            if (string.length() > m) {
//                answer = string;
//                m = string.length();
//            }
//        }
        while((pos = str.indexOf(' '))!=-1){
            String tmp = str.substring(0, pos);
            if(tmp.length() > m){
                m = tmp.length();
                answer = tmp;
            }
            str = str.substring(pos+1);
        }
        if(str.length()>m){
            answer = str;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(solution(str));
    }
}
