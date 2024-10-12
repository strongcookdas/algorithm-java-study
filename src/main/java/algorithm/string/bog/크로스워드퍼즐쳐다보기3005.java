package algorithm.string.bog;

import java.util.*;

public class 크로스워드퍼즐쳐다보기3005 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int R = kb.nextInt();
        int C = kb.nextInt();
        kb.nextLine();

        char[][] map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String input = kb.nextLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        크로스워드퍼즐쳐다보기3005 main = new 크로스워드퍼즐쳐다보기3005();
        System.out.println(main.solution(R, C, map));
    }

    private String solution(int R, int C, char[][] map) {
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < C; j++) {
                sb.append(map[i][j]);
            }
            String[] arr = sb.toString().split("#");
            for (String str : arr) {
                if (str.length() > 1) {
                    list.add(str);
                }
            }
        }
        for (int j = 0; j < C; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < R; i++) {
                sb.append(map[i][j]);
            }
            String[] arr = sb.toString().split("#");
            for (String str : arr) {
                if (str.length() > 1) {
                    list.add(str);
                }
            }
        }
        Collections.sort(list);
        return list.get(0);
    }
}
