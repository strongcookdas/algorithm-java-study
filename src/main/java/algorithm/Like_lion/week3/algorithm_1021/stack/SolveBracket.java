package algorithm.Like_lion.week3.algorithm_1021.stack;

import java.util.Stack;

public class SolveBracket {


    public boolean solution1(String s) {
        while (s.indexOf("()") != -1) {
            s = s.replace("()", "");
        }
        return s.length()==0;
    }



    public boolean solution2(String s) {
        while (s.indexOf("()") != -1) {
            String[] tmp = s.split("\\(\\)");
            s = String.join("",tmp);
        }
        return s.length()==0;
    }


    public boolean solution3(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                stack.push("(");
            }

            if(s.charAt(i)==')'){
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.size()==0;
    }
    public boolean solution(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                cnt++;
            }

            if(s.charAt(i)==')'){
                if(cnt<1){
                    return false;
                }
                cnt--;
            }
        }
        return cnt ==0;
    }

}
