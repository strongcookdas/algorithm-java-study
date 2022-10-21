package week3.algorithm_1021.stack;

import java.util.EmptyStackException;
import java.util.Stack;

public class SolveBracket {

    Stack<String> stack = new Stack<>();

    /*
    public boolean solution(String s) {
        while (s.indexOf("()") != -1) {
            s = s.replace("()", "");
        }
        return s.length()==0;
    }
     */

    /*
    public boolean solution(String s) {
        while (s.indexOf("()") != -1) {
            String[] tmp = s.split("\\(\\)");
            s = String.join("",tmp);
        }
        return s.length()==0;
    }
     */

    public boolean solution(String s) {
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
}
