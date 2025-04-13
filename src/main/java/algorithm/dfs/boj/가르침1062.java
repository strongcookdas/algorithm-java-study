package algorithm.dfs.boj;

import java.util.*;
import java.io.*;

public class 가르침1062 {
    static int N, K, max = 0;
    static List<String> words = new ArrayList<>();
    static boolean[] visited = new boolean[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (K < 5) {
            System.out.println(0);
            return;
        }

        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            words.add(str);
        }

        dfs(0, 0);
        System.out.println(max);
    }

    static void dfs(int index, int count) {
        if (count == K - 5) {
            int readable = 0;
            for (String word : words) {
                boolean canRead = true;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (!visited[c - 'a']) {
                        canRead = false;
                        break;
                    }
                }
                if (canRead) readable++;
            }
            max = Math.max(max, readable);
            return;
        }

        for (int i = index; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }
}

