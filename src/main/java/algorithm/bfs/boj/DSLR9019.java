package algorithm.bfs.boj;

/**
 * BFS 활용
 * DSLR 적용하면서 최단 적용 횟수를 찾는다.
 * 큐 2개 사용 숫자, 적용메뉴
 * 
 * 오답 원인
 * 방문 체크 큐로 함 poll하기 때문에 큐로 하면 안됨
 * 문제 잘못읽어 수식을 잘못세움
 */

import java.util.*;
import java.io.*;

public class DSLR9019 {
    private int D(Integer number) {
        return (2 * number) % 10000;
    }

    private int S(Integer number) {
        return (number == 0) ? 9999 : number - 1;
    }

    private int L(Integer number) {
        return (number % 1000) * 10 + (number / 1000);
    }

    private int R(Integer number) {
        return (number % 10) * 1000 + (number / 10);
    }

    public String solution(int num1, int num2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();

        q1.offer(num1);
        visited.add(num1);
        q2.offer("");

        while (!q1.isEmpty()) {
            int n = q1.size();
            for (int i = 0; i < n; i++) {
                Integer number = q1.poll();
                String commands = q2.poll();
                if (number == num2) return commands;

                int[] results = {D(number), S(number), L(number), R(number)};
                char[] operations = {'D', 'S', 'L', 'R'};
                for (int j = 0; j < 4; j++) {
                    int result = results[j];
                    if (!visited.contains(result)) {
                        visited.add(result);
                        q1.offer(result);
                        q2.offer(commands + operations[j]);
                    }
                }
            }
        }
        return "";
    }


    public static void main(String[] args) throws IOException {
        DSLR9019 main = new DSLR9019();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        while ((N--) > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            bw.write(main.solution(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
