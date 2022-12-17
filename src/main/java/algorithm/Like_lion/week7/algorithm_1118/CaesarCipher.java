package algorithm.Like_lion.week7.algorithm_1118;

public class CaesarCipher {
    public String solution(String s, int n) {

        String ans = "";

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                int word = (char) (s.charAt(i) + n);
                if (word > 'z') {
                    word = 'a' + (word - 'z') - 1;
                }
                ans += (char) word;
            } else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                int word = (char) (s.charAt(i) + n);
                if (word > 'Z') {
                    word = 'A' + (word - 'Z') - 1;
                }
                ans += (char) word;
            } else {
                ans += s.charAt(i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        CaesarCipher c = new CaesarCipher();

        System.out.println(c.solution("aBz", 4));
    }
}
