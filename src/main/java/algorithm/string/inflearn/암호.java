package algorithm.string.inflearn;

import java.util.Scanner;

public class 암호 {
    public static String solution(int count, String str) {
        String answer = "";
//        StringBuilder builder = new StringBuilder(answer);
//        int index = 0;
//        while(index<count*7){
//            String tmp = str.substring(index,index+7);
//            tmp = tmp.replace('#','1').replace('*','0');
//            builder.append((char)(Integer.parseInt(tmp,2)));
//            index+=7;
//        }
        for (int i = 0; i < count; i++) {
            String tmp = str.substring(0, 7).replace('#', '1').replace('*', '0');
            int n = Integer.parseInt(tmp,2);
            answer += (char) n;
            str = str.substring(7);

        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        String str = scanner.next();
        System.out.println(solution(count, str));
    }
}
