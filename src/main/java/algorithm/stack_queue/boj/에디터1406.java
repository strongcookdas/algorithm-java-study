package algorithm.stack_queue.boj;
/**
 * Stack 활용 커서 기준으로 왼쪽, 오른쪽 문자를 담을 스택 생성 커서의 위치는 왼쪽 문자 스택 top L이 입력될 경우 왼쪽 스택 top에 위치한 문자 pop 후 오른쪽 문자 스택에 push top이 있는지
 * 확인 필요 D가 입력될 경우 오른쪽 문자 스택 pop후 왼쪽 stack push B가 입력될 경우 왼쪽 문자 스택 pop P가 입력될 경우 - 왼쪽 문자 스택 문자 push
 */

import java.util.*;
import java.io.*;

public class 에디터1406 {
    Stack<Character> leftStack;
    Stack<Character> rightStack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        에디터1406 main = new 에디터1406();

        String str = br.readLine();
        main.initLeftStack(str);

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String menu = st.nextToken();
            if (menu.equals("L")) {
                main.L();
            } else if (menu.equals("D")) {
                main.D();
            } else if (menu.equals("B")) {
                main.B();
            } else {
                main.P(st.nextToken().charAt(0));
            }
        }

        System.out.println(main.getString());
    }

    private String getString() {
        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }
        StringBuilder sb = new StringBuilder("");
        while (!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }
        return sb.toString();
    }

    private void P(char s) {
        leftStack.push(s);
    }

    private void B() {
        if (!leftStack.isEmpty()) {
            leftStack.pop();
        }
    }

    private void D() {
        if (!rightStack.isEmpty()) {
            leftStack.push(rightStack.pop());
        }
    }

    private void L() {
        if (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }
    }

    private void initLeftStack(String str) {
        leftStack = new Stack<>();
        rightStack = new Stack<>();
        for (char c : str.toCharArray()) {
            leftStack.push(c);
        }
    }
}
