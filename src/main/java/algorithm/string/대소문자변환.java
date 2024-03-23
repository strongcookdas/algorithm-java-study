package algorithm.string;

import java.util.*;

public class 대소문자변환 {
    public static String solution(String str){
        String answer = "";
        for(char x : str.toCharArray()){
//            if(Character.isLowerCase(x)) answer+=Character.toUpperCase(x);
//            else answer+=Character.toLowerCase(x);
            if(x >= 65 && x <= 90){
                x += 32;
                answer += x;
            }else{
                x -= 32;
                answer += x;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(solution(str));
    }
}
