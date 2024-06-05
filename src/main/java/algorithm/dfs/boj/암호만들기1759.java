package algorithm.dfs.boj;
/**
 * DFS 활용
 * 조건
 * 최소 한개의 모음, 최소 두개의 자음, 오름차순
 * 과정
 * DFS로 순열을 구하는 방식으로 푼다.
 * 길이가 L일 때 조건을 확인 후 만족하면 출력
 */

import java.io.*;
import java.util.*;
public class 암호만들기1759 {
    int L, C;
    final char[] vowel = {'a', 'e', 'i', 'o', 'u'};
    char[] words;
    char[] password;

    public String DFS(int level, int n) {
        StringBuilder sb = new StringBuilder("");
        if (level == L) {
            int vowelCount = 0;
            for (int i = 0; i < password.length; i++) {
                for (int j = 0; j < vowel.length; j++)
                    if (password[i] == vowel[j]) vowelCount++;
            }
            if (vowelCount >= 1 && L - vowelCount >= 2) return String.valueOf(password)+"\n";
        } else {
            for (int i = n; i < C; i++) {
                password[level] = words[i];
                sb.append(DFS(level + 1, i + 1));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        암호만들기1759 main = new 암호만들기1759();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        main.L = Integer.parseInt(st.nextToken());
        main.C = Integer.parseInt(st.nextToken());

        main.password = new char[main.L];
        main.words = new char[main.C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < main.C; i++) main.words[i] = st.nextToken().charAt(0);

        Arrays.sort(main.words);
        System.out.println(main.DFS(0,0));
    }
}
