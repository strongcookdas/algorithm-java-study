package week3.algorithm_1021.stack;

import java.util.EmptyStackException;

public class SolveBracket {

    public boolean solution(String s) {
        while (s.indexOf("()") != -1) {
            s = s.replace("()", "");
        }
        return s.length()==0;
    }
}
