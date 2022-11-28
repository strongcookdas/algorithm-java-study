package week9.algorithm_1128;

public class AlphabetCombination {
    public void solution(){
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                System.out.println((char)('a'+i)+" "+(char)('a'+j));
            }
        }
    }

    public static void main(String[] args) {
        new AlphabetCombination().solution();
    }
}
