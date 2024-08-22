package algorithm.brute_force.boj;

import java.util.*;
import java.io.*;

public class 집합11723 {
    int bit = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        집합11723 main = new 집합11723();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String menu = st.nextToken();
            if (menu.equals("add")) {
                main.add(Integer.parseInt(st.nextToken()));
            } else if (menu.equals("remove")) {
                main.remove(Integer.parseInt(st.nextToken()));
            } else if (menu.equals("check")) {
                bw.write(main.check(Integer.parseInt(st.nextToken())) + "\n");
            } else if (menu.equals("toggle")) {
                main.toggle(Integer.parseInt(st.nextToken()));
            } else if (menu.equals("all")) {
                main.all();
            } else {
                main.empty();
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private void empty() {
        bit = 0;
    }

    private void all() {
        bit = (1 << 21) - 1;
    }

    private void toggle(int i) {
        bit ^= (1 << i);
    }

    private String check(int i) {
        if ((bit & (1 << i)) == (1 << i)) {
            return "1";
        }
        return "0";
    }

    private void remove(int i) {
        bit &= ~(1 << i);
    }

    private void add(int i) {
        bit |= (1 << i);
    }
}
