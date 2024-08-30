package algorithm.string.bog;

import java.util.*;

public class IOIOI5525 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int M = kb.nextInt();
        kb.nextLine();

        String input = kb.nextLine();

        IOIOI5525 main = new IOIOI5525();
        System.out.println(main.solution(N, input));
    }

    private int solution(int N, String input) {
        int count = 0;
        int pCount = 0;
        int i = 0;
        while (i < input.length() - 1) {
            if (input.charAt(i) == 'I' && input.charAt(i + 1) == 'O' && i + 2 < input.length()
                    && input.charAt(i + 2) == 'I') {
                pCount++;
                if (pCount == N) {
                    pCount--;
                    count++;
                }
                i += 2;
            } else {
                pCount = 0;
                i++;
            }
        }
        return count;
    }
}
