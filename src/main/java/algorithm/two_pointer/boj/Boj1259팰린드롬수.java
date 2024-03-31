package algorithm.two_pointer.boj;

import java.io.*;
import java.util.*;

public class Boj1259팰린드롬수 {
    public static String solution(String str) {
        int lt = 0, rt = str.length() - 1;
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(lt++) != str.charAt(rt--)) return "no";
        }
        return "yes";
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            input = scanner.nextLine();
            if (input.equals("0")) break;
            System.out.println(solution(input));
        }
    }
}
